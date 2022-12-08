import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.{ArrayType, StringType, StructType,IntegerType,BooleanType}
import org.apache.spark.sql.functions.lit
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.functions._ //for count()

import scala.collection.Seq

object RDDParallelize{

  //def otherwise(str: String) = ???

  def main(args: Array[String]): Unit={
    val spark:SparkSession = SparkSession.builder().master("local[1]")
      .appName("SparkByExamples.com")
      .getOrCreate()

    // пример 1
    //val rdd = spark.sparkContext.parallelize(Seq(("Java",20000),
    //  ("Python",1000)))
    //rdd.foreach(println)

    import spark.implicits._

    // пример 2

    //val columns1=Seq("language","user_count")
    // val data = Seq(("Java", "20000"), ("Python","1000"))
    //val rdd = spark.sparkContext.parallelize(data)
    //val dfFromRDD1 = rdd.toDF("language","user_count")
    //dfFromRDD1.printSchema()   //создается и выводится схема

    //пример 3

    //val data = Seq(("James", "Smith", "USA","CA"),
    //  ("Piter","Rose", "USA", "NY"))
    //val columns=Seq("firstname","secondname","country", "state")
    //val df = data.toDF(columns:_*) //коллекция в дата фрейм
    //df.show()
    //df.select("firstname","lastname").show()

    //пример 4

    val data = Seq(Row(Row("James", "","Smith"), List("Java","Scala", "C++"), "324323","M","4324","NY"),
      Row(Row("Piter","","Rose"), List("Pascal","Scala", "C++"), "39423", "M", "435453","OH"))

    val shema = new StructType()
      .add("name",new StructType()
      .add("firstname",StringType)
      .add("midlename",StringType)
      .add("lastname", StringType))
      .add("languages",ArrayType(StringType))
      .add("dob",StringType)
      .add("gender",StringType)
      .add("salary",StringType)
      .add("state",StringType)

    var df = spark.createDataFrame(spark.sparkContext.parallelize(data),shema) //создаем дата фрейм

    import org.apache.spark.sql.functions.lit
    import org.apache.spark.sql.functions.col
    df = df.withColumn("Country",lit("USA")) //добавление колонки
    //df = df.withColumn("salary",col("salary").cast("Integer") //поменять тип
    df = df.withColumnRenamed("gender","sex") //переименовать
    df = df.drop("dob") //удалить колонку ДР

    //df.printSchema()
    //df.show()

    //df.filter(df("state")==="OH").show(false) //фильтр по штату OH
    //df.filter("gender == 'M'").show(false)
    //df.where("gender == 'M'").show(false)

    //multiple condition // несколько условий
    //df.filter(df("state") === "OH" && df("gender") === "M")
    //  .show(false)

    // по списку внутри
    //import org.apache.spark.sql.functions.array_contains
    //df.filter(array_contains(df("languages"), "Java"))
    //  .show(false)

    //Struct condition /// внутри struct
    //df.filter(df("name.lastname") === "Smith")
    //  .show(false)

//    a. Создайте схему будущего фрейма данных. Схема должна включать следующие атрибуты:
//    ·   id -  уникальный идентификатор посетителя сайта. Тип – последовательность чисел фиксированной длины. Данное поле не является первичным ключом.
//    ·   timestamp – дата и время события в формате unix timestamp.
//    ·   type – тип события, значение из списка (факт посещения(visit), клик по визуальному элементу страницы(click), скролл(scroll), перед на другую страницу(move)).
//    ·   page_id – id текущей страницы. Тип - последовательность чисел фиксированной длины.
//    ·   tag – каждая страница с новостью размечается редакцией специальными тегами, которые отражают тематику конкретной новости со страницы. Возможный список тематик: политика, спорт, медицина и т.д.
//    ·   sign – наличие у пользователя личного кабинета. Значения – True/False.

//    b.Создайте датафрейм с описанной выше схемой данных.
//    c.Наполните датафрейм данными.Пример:
//      (12345, 1667627426, "click", 101, "Sport”, False)

    val data1 = Seq(Row(12345, "1667627426", "click", 101, "Sport", false),
      Row(12346, "1667627426", "visit", 102, "Sport", false),
      Row(12346, "1667627427", "click", 102, "Sport", false),
      Row(12346, "1667627428", "click", 101, "Sport", false),
      Row(12346, "1667627429", "visit", 112, "Sport", false),
      Row(12347, "1667627430", "visit", 113, "Sport", true),
      Row(12347, "1667627426", "move", 123, "Sport", true),
      Row(12346, "1667625526", "click", 122, "Sport", false),
      Row(12347, "1667627426", "visit", 103, "Sport", true),
      Row(12347, "1667627426", "visit", 103, "Sport", true),
      Row(11447, "1667627426", "visit", 103, "Sport", true),
      Row(11447, "1887625526", "visit", 103, "Sport", true),
      Row(11447, "1667627426", "visit", 203, "Medicine", true),
      Row(11447, "1667627426", "visit", 201, "Medicine", true),
      Row(10347, "1668827426", "visit", 204, "Medicine", true),
      Row(10347, "1667627426", "visit", 211, "Medicine", true),
      Row(10347, "1667627426", "visit", 251, "Medicine", true),
      Row(10006, "1567627426", "click", 122, "Sport", false),
      Row(12348, "1467625526", "move", 104, "Sport", true))

    val shema1 = new StructType()
      .add("id", IntegerType)
      .add("timestamp", StringType)
      .add("type", StringType)
      .add("page_id",IntegerType)
      .add("tag", StringType)
      .add("sign", BooleanType)

    var df1 = spark.createDataFrame(spark.sparkContext.parallelize(data1), shema1) //создаем дата фрейм

    df1.printSchema()
    df1.show()

    //-------------------- Вывести топ-5 самых активных посетителей сайта

    import org.apache.spark.sql.functions._ //for count()
    import org.apache.spark.sql.functions.desc
    //df1.groupBy("id").agg(max("page_id"),count("page_id").as("count_peop")).show()
    //df1.groupBy("id").agg(count("page_id").as("count_peop")).sort(col("count_peop")).show()
    df1.groupBy("id")
      .agg(count("page_id").as("count_peop"))
      .sort(desc("count_peop"))
      .show(5)


    //-------------------- Посчитать процент посетителей, у которых есть ЛК

    import org.apache.spark.sql.expressions._
    import org.apache.spark.sql.functions._

    // первый способ (неудано)

    //df1.filter("type == 'click'").show(false)
    //df1.filter("sign == true").show(false)         //просмотр таблицы для проверки
    val rows = df1.count()
    val rows_true = df1.filter("sign == true").count()
    val rows_percent = rows_true / rows  /// типичное целочисленное деление, что интересно, что в таблице дробные
    /// интересно можно ли сделать в дробных как ниже, пока не придумала как
    print("\n (тестирование spark) --->  fraction : ")
    print(rows_percent)
    println("\n ")

    // второй способ

    df1
      .groupBy("sign")
      .agg(count("id").as("sign_count"))
      .withColumn("fraction", col("sign_count") / sum("sign_count").over())
      .show()


    //-------------------- Вывести топ-5 страниц сайта по показателю общего кол-ва кликов на данной странице

    df1.groupBy("page_id")
      .agg(count("id").as("count_peop"))
      .sort(desc("count_peop"))
      .show(5)


    //-------------------- Добавьте столбец к фрейму данных со значением временного диапазона в рамках суток с размером окна – 4 часа(0-4, 4-8, 8-12 и т.д.)

    df1=df1
      .withColumn("date", from_unixtime(col("timestamp"),"MM-dd-yyyy"))
      .withColumn("time", from_unixtime(col("timestamp"),"HH:mm:ss"))
      .withColumn("time_H", from_unixtime(col("timestamp"),"HH").cast("Integer"))
      //.withColumn("time_range", when(col("timestamp")==="1667627426","0-4"))
      .withColumn("time_range", when(col("time_H") >=0 && col("time_H")<4,"0-4")
        .when(col("time_H") >=4 && col("time_H")<8,"4-8")
        .when(col("time_H") >=8 && col("time_H")<12,"8-12")
        .when(col("time_H") >=12 && col("time_H")<16,"12-16")
        .when(col("time_H") >=16 && col("time_H")<18,"16-18")
        .when(col("time_H") >=18 && col("time_H")<24,"18-24"))


     df1.show()

    //val df2 = df1.select(
    //  from_unixtime(col("timestamp"), "MM-dd-yyyy HH:mm:ss").as("timestamp_2") )
    //df2.show()

    //-------------------- Выведите временной промежуток на основе предыдущего задания, в течение которого было больше всего активностей на сайте.

    df1.groupBy("time_range")
      .agg(count("id").as("activity_counter"))
      .sort(desc("activity_counter"))
      .show(1)

    //-------------------- Создайте второй фрейм данных, который будет содержать информацию о ЛК посетителя сайта со следующим списком атрибутов
    //1.       Id – уникальный идентификатор личного кабинета
    //2.       User_id – уникальный идентификатор посетителя //(сопоставл с др таблицей)
    //3.       ФИО посетителя
    //4.       Дату рождения посетителя
    //5.       Дата создания ЛК
    //|12347|         4|
    //|11447|         4|
    //|10347|         3|

    val data2 = Seq(Row(600001, 12347,  "Petrov Alexey",  "11-05-2010", "1-05-1980"),
      Row(600002, 11447, "Ivanov Ivan", "12-05-2011", "2-07-1990"),
      Row(600003, 10347, "Sidorov Sergey", "13-05-2012", "3-08-2000"))

    val shema2 = new StructType()
      .add("id", IntegerType)
      .add("User_id", IntegerType)
      .add("FullName", StringType)
      .add("bod", StringType)
      .add("reg_date", StringType)

    //CAST(UNIX_TIMESTAMP('08/26/2016', 'MM/dd/yyyy') AS TIMESTAMP)

    var df2 = spark.createDataFrame(spark.sparkContext.parallelize(data2), shema2) //создаем дата фрейм

    //df2 = df2
      //.withColumn("bod", from_unixtime(col("timestamp"), "MM-dd-yyyy"))

    df2.printSchema()
    df2.show()
    //-------------------- Вывести фамилии посетителей, которые читали хотя бы одну новость про спорт.

    var df3 = df1.join(df2, df1("id") === df2("User_id"),"inner")
      //.show(false)

    df3.filter(df3("tag")==="Sport")
      .show(false) //для проверки как сджойнилось

    df3.filter(df3("tag")==="Sport")
      .select("FullName")
      .dropDuplicates("FullName")
      .show(false) //вывод фамилий
  }
}