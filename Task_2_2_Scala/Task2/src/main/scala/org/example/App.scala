package org.example
import scala.io.StdIn.readLine //импорт cin / input

/**
 * @author ${daraseliya.a}
 */

object App {
  def main(args : Array[String]) {
    // пункт а.
    println("\n-- Пункт a. --")
    var startStringVar = "Hello, Scala!"
    println(startStringVar)
    println(startStringVar.reverse) // наоборот
    println(startStringVar.toLowerCase()) // регистр, как в java
    println(startStringVar.init) //убрать последнее
    println(startStringVar.replace( "!",  "")) // как в python
    println(startStringVar.dropRight(1)) // убрать один элемент справа
    println(startStringVar.init + " and goodbye python!")

    // пункт b.
    println("\n-- Пункт b. --")
    println("Введите годовой доход: ")
    val yearSalary = readLine().toInt
    println("Введите размер премии: ")
    val annualBonus = readLine().toFloat
    println("Введите стоимость компенсации питания: ")
    val eatBonus = readLine().toInt

    val monthlySalary = (yearSalary*annualBonus + eatBonus + yearSalary)*0.87 /12 //
    println(s"Ежемесячный оклад сотрудника после вычета налогов: $monthlySalary")
    // .getClass возвращает класс

    // пункт с.
    println("\n-- Пункт c. --")
    val firstList = List(100, 150, 200, 80, 120, 75)
    val commonSalary = firstList.sum
    val countPersons = firstList.size
    println("Отклонение от среднего значения оклада на уровень всего отдела: " + commonSalary/countPersons )

    // пункт d.
    println("\n-- Пункт d. --")
    var secondList = firstList :+ 180 // вместо apply
    //val secondList = firstList.apply(180) //выдает ошибку (пока не понятно почему)
    //println(secondList)
    println("Максимум: " + secondList.max)
    println("Минимум: " + secondList.min)

    // пункт e.
    println("\n-- Пункт e. --")
    //println(Console.BLUE +"\n-- Пункт e. --"+Console.WHITE)
    secondList =secondList :+ 350
    secondList =secondList :+ 90
    println(secondList.sortWith(_ < _))

    // пункт f.
    println("\n-- Пункт f. --")
    var thirdListSorted = secondList.sortWith(_ < _)
    println("До добавления\n"+ thirdListSorted)

    val newSalary1 = 130

    var ii = 0
    val s = thirdListSorted.size
    while (ii < s && thirdListSorted(ii)<=newSalary1) {
      ii += 1
    }
    //println("Вставляем в List элемент до индекса " + ii + ", где число " + thirdListSorted(ii))

    // в питоне есть готовая insert(positionIndex,addingElement)
    // работает, но кривовато, потом возникают сложности с его использованием (следующие пункты в комментариях)
    def insert(list: List[Any], i: Int, value: Any) = {
      list.take(i) ++ List(value) ++ list.drop(i)
    }
    var forthList = insert(thirdListSorted, ii, newSalary1)
    println("После добавления\n"+forthList)

    // пункт g.
    println("\n-- Пункт g. --")
    println("Введите минимальную зарплату для специалистов уровня middle: ")
    val middleMinSalary = readLine().toInt
    println("Введите максимальную зарплату для специалистов уровня middle: ")
    val middleMaxSalary = readLine().toInt
    println("----- Первый способ ")
    //for (n <- forthList) // не понятный пока момент: почему для  List  c insert выдает ошибку
    for (n <- thirdListSorted) //secondList
    {
      if ((n >= middleMinSalary) && (n <= middleMaxSalary))
        println(f"зп $n  middle")
    }
    /// можно сделать еще по другому:
    println("----- Другой способ")

    var iii = 0
    val ss = thirdListSorted.size
    while (iii < ss ) {
     //if ((forthList(iii)>=middleMinSalary) && (forthList(iii)<=middleMaxSalary)) // не работает с LisT после использования insert
      if ((thirdListSorted(iii)>=middleMinSalary) && (thirdListSorted(iii)<=middleMaxSalary))
        {println(f"Сотрудник № $iii : middle уровень | зп "+thirdListSorted(iii))}
      iii += 1
    }

    // проверка списка выше (почему <= не сработал)
    // число, но тогда не понятно почему нельзя использовать операторы сравнения <=
    /*
    var iiii = 0
    val sss = forthList.size
    while (iiii < sss) {
       println(forthList(iiii).getClass + " " + iiii) //class java.lang.Integer
       iiii += 1
    }*/

    // пункт h.
    println("\n-- Пункт h. --")
    var fifthList  = thirdListSorted.map(x => x*1.07)
    println("После индексирования зарплаты каждого сотрудника на уровень инфляции\n"+fifthList)

    // ---------------------------------------------------------------------------------------

    // пункт i.
    println("\n-- Пункт i. --")

    var avrSalaryByMarketJunior = 80
    var avrSalaryByMarketMiddle = 175
    var avrSalaryByMarketSenior = 300

    println("Введите среднее значение зарплаты на рынке для Junior: ")
    avrSalaryByMarketJunior= readLine().toInt
    println("Введите среднее значение зарплаты на рынке для  Middle: ")
    avrSalaryByMarketMiddle = readLine().toInt
    println("Введите среднее значение зарплаты на рынке для  Senior: ")
    avrSalaryByMarketSenior = readLine().toInt

    var middleSalary = List[Int]()
    var juniorSalary = List[Int]()
    var seniorSalary = List[Int]()
    //junior, middle и senior

    for (j <-thirdListSorted) ////используется начальный список зп firstList (без сортировки) - ошибка из пункта g.
      {
        if ((j >= middleMinSalary) && (j <= middleMaxSalary))
          { middleSalary = j +: middleSalary }
        else if (j < middleMinSalary)
          { juniorSalary = j +: juniorSalary  }
        else seniorSalary = j +: seniorSalary

      }

    //println(juniorSalary)
    //println(middleSalary)
    //println(seniorSalary)

    val avrMiddleSalary = middleSalary.sum / middleSalary.size
    val avrJuniorSalary = juniorSalary.sum / juniorSalary.size
    val avrSeniorSalary = seniorSalary.sum / seniorSalary.size

    val avrMiddleSalaryDiff:Double = 1-  avrMiddleSalary.toDouble/ avrSalaryByMarketMiddle.toDouble
    var avrJuniorSalaryDiff:Double = 1- avrJuniorSalary.toDouble / avrSalaryByMarketJunior.toDouble
    var avrSeniorSalaryDiff:Double = 1- avrSeniorSalary.toDouble / avrSalaryByMarketSenior.toDouble

    println("Junior: " + avrJuniorSalaryDiff)
    println("Middle: " + avrMiddleSalaryDiff)
    println("Senior: " + avrSeniorSalaryDiff)

    // пункт k.
    println("\n-- Пункт k. --")

    //без имени
    val workerSalaryMap = Map(
      "Иванов" -> 100,
      "Петров" -> 150,
      "Сидоров" -> 80,
      "Смирнов" -> 75,
      "Кузнецов" -> 90,
      "Попов" -> 120,
      "Васильев"-> 180,
      "Соколов" -> 200,
      "Михайлов"-> 350
    )
    for ((i, j) <- workerSalaryMap) {
      println(i, j)
    }

    // пункт l.
    println("\n-- Пункт l. --")

    var maxSalary=0
    var minSalary=thirdListSorted.max
    var workerWithMaxSalary = ""
    var workerWithMinSalary = ""

    for ((i,j) <-  workerSalaryMap)
      {
        //println(i,j)
        if (j>maxSalary)
          {
            maxSalary = j
            workerWithMaxSalary = i
          }
        if (j < minSalary) {
          minSalary = j
          workerWithMinSalary = i
        }
      }

    println(workerWithMaxSalary + " и " + workerWithMinSalary)

    // пункт o.
    println("\n-- Пункт o. --")
    ///рекурсия пример на факториале

    def factorial(n: Int): Int =
      {
        if (n  <= 0) 1
        else
          {
            var fact = n*factorial(n-1)
            fact
          }
      }

    //println(factorial(5))

    // хвостовая рекурсия

    def factorialTail(n: Int): Int =
      {
        def loop(x: Int, acc: Int): Int =
          {
            if (x<=0) 1
            else x*loop (x-1,acc)
          }
        loop(n,1)
      }

    //println(factorialTail(5))

    // для степени двойки (для положительной степени и для отрицательной степени)

    def power2func(n: Int): Double = {
      if (n == 0) 1
      else if (n > 0){
        var power2var = 2 * power2func(n - 1)
        power2var
      }
      else  {
        var power2var =  power2func(n + 1) /2
        power2var
      }
    }

    println(power2func(3))
    println(power2func(-2))

    def power2funcTail(n: Int): Double = {
      def loop(x: Int, acc: Int): Double = {
        if (x == 0) 1
        else if (x > 0)  2 * loop(x - 1, acc)
        else  loop(x + 1, acc) /2
      }
      loop(n, 1)
    }

    println(power2funcTail(3))
    println(power2funcTail(-2))
  }

}
