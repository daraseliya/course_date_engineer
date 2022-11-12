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
    println("----- Первый способ (не получился, работает только на несортированном списке)")
    //for (n <- forthList) // не понятный пока момент: почему для отсортированного List выдает ошибку
    for (n <- firstList)
    {
      if ((n >= middleMinSalary) && (n <= middleMaxSalary))
        println(f"зп $n  middle")
    }
    /// можно сделать еще по другому (поскольку верхний работает не совсем так, как хочется):
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
  }

}
