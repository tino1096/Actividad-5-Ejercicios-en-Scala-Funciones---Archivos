import java.io._

object funcionesArchivos {

  def main(args: Array[String]): Unit = {

    var archivo = new File("Archivo.java")
    if (archivo.exists()) {
      if (archivo.canRead) {

        // Cantidad de lineas de codigo.
        cantidadDeLineas(archivo)
        // Cantidad de lineas en blanco.
        cantidadDeLineasEnBlanco(archivo)
        // Paréntensis balanceados.
        parentesisBalanceados(archivo)
        // LLaves balanceadas.
        llavesBalanceadas(archivo)
        // Corchetes balanceados.
        corchetesBalanceados(archivo)

      }
    } else {
      println("El archivo no esta disponible")
    }

  }

  def cantidadDeLineas(archivo: File): Unit = {
    var fr = new FileReader(archivo)
    var br = new BufferedReader(fr)
    println("Cantidad de lineas del archivo: " + br.lines().count().toInt + ".")
  }

  def cantidadDeLineasEnBlanco(archivo: File): Unit = {
    var fr = new FileReader(archivo)
    var br = new BufferedReader(fr)
    var ref: Int = 0;
    var cantidadLineasBlancas: Int = 0; ;

    //Lectura
    var linea: String = br.readLine()
    if (linea != null) {
      do {
        var contenido = linea.toCharArray()
        for (caracter <- contenido) {
          if (caracter != " ") {
            ref = ref + 1;
          }
        }
        if (ref == 0) {
          cantidadLineasBlancas = cantidadLineasBlancas + 1;
        }
        ref = 0;

        linea = br.readLine()
      } while (linea != null)
    }

    println("Cantidad de lineas en blanco: " + cantidadLineasBlancas + ".")

  }

  def parentesisBalanceados(archivo: File): Unit = {
    var fr = new FileReader(archivo)
    var br = new BufferedReader(fr)

    var parentesisAbiertos: Int = 0; ;
    var parentesisCerrados: Int = 0; ;

    var linea: String = br.readLine()
    if (linea != null) {
      do {
        var contenido = linea.toCharArray()
        for (caracter <- contenido) {
          if (caracter == "(") {
            parentesisAbiertos = parentesisAbiertos + 1;
          }
          if (caracter == ")") {
            parentesisCerrados = parentesisCerrados + 1;
          }
        }

        linea = br.readLine()
      } while (linea != null)
    }

    if (parentesisAbiertos == parentesisCerrados) {
      println("Paréntensis balanceados: Si.")
    } else {
      if (parentesisAbiertos > parentesisCerrados) {
        println("Paréntensis balanceados: No, debe cerrar " + (parentesisAbiertos - parentesisCerrados) + ".")
      } else {
        println("Paréntensis balanceados: No, debe abrir " + (parentesisCerrados - parentesisAbiertos) + ".")
      }
    }

  }

  def llavesBalanceadas(archivo: File): Unit = {

    var fr = new FileReader(archivo)
    var br = new BufferedReader(fr)

    var llavesAbiertas: Int = 0; ;
    var llavesCerradas: Int = 0; ;

    var linea: String = br.readLine()
    if (linea != null) {
      do {
        var contenido = linea.toCharArray()
        for (caracter <- contenido) {
          if (caracter == "{") {
            llavesAbiertas = llavesAbiertas + 1;
          }
          if (caracter == "}") {
            llavesCerradas = llavesCerradas + 1;
          }
        }

        linea = br.readLine()
      } while (linea != null)
    }

    if (llavesAbiertas == llavesCerradas) {
      println("Llaves balanceadas: Si.")
    } else {
      if (llavesAbiertas > llavesCerradas) {
        println("Llaves balanceadas: No, debe cerrar " + (llavesAbiertas - llavesCerradas) + ".")
      } else {
        println("Llaves balanceadas: No, debe abrir " + (llavesCerradas - llavesAbiertas) + ".")
      }
    }

  }

  def corchetesBalanceados(archivo: File): Unit = {

    var fr = new FileReader(archivo)
    var br = new BufferedReader(fr)

    var corchetesAbiertos: Int = 0; ;
    var corchetesCerrados: Int = 0; ;

    //Lectura
    var linea: String = br.readLine()
    if (linea != null) {
      do {
        var contenido = linea.toCharArray()
        for (caracter <- contenido) {
          if (caracter == "(") {
            corchetesAbiertos = corchetesAbiertos + 1;
          }
          if (caracter == ")") {
            corchetesCerrados = corchetesCerrados + 1;
          }
        }

        linea = br.readLine()
      } while (linea != null)
    }

    if (corchetesAbiertos == corchetesCerrados) {
      println("Corchetes balanceados: Si.")
    } else {
      if (corchetesAbiertos > corchetesCerrados) {
        println("Corchetes balanceados: No, debe cerrar " + (corchetesAbiertos - corchetesCerrados) + ".")
      } else {
        println("Corchetes balanceados: No, debe abrir " + (corchetesCerrados - corchetesAbiertos) + ".")
      }
    }

  }

}

