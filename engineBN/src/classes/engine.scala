package classes

class engine {
  
  def Prueba(hola:Int):Int=
  {
    var sum:Int=0
    sum=hola+hola
    return sum
  }
  
  var poneracion_categoria:Double=0.45
  var poneracion_autor:Double=0.45
  var poneracion_palabra_clave:Double=0.1
  
  def Similitud():Double=
  {
    var similitud:Double = SimilitudCategoria(null, null, null) + SimilitudAutor(null, null, null) + SimilitudPalabrasClave(null, null, null)
    return similitud
  }
  
  //Similitud para la categoria
  def SimilitudCategoria(categoria_libro:List[String], categoria_lector:List[String], poneracion_lector:List[Int]):Double=
  {
    var cont_categorias:Double=0
    var poneracion:Double=0
    for(categoria <- categoria_libro)
    {
      var index:Int=categoria_lector.indexOf(categoria)
      if(!index.equals(-1)){
        cont_categorias+=1
        poneracion+=poneracion_lector(index)/poneracion_lector.sum
      }
    }
    poneracion=poneracion*(cont_categorias/categoria_libro.length)*poneracion_categoria
    return poneracion;
  }
  //Similitud para el autor
  def SimilitudAutor(autor_libro:List[Int], autor_lector:List[Int], poneracion_lector:List[Int]):Double=
  {
    var cont_categorias:Double=0
    var poneracion:Double=0
    for(categoria <- autor_libro)
    {
      var index:Int=autor_lector.indexOf(categoria)
      if(!index.equals(-1)){
        cont_categorias+=1
        poneracion+=poneracion_lector(index)/poneracion_lector.sum
      }
    }
    poneracion=poneracion*(cont_categorias/autor_libro.length)*poneracion_autor
    return poneracion;
  }
  //Similitud para las palabras clave
  def SimilitudPalabrasClave(palabrasclave_libro:List[Int], palabrasclave_lector:List[Int], poneracion_lector:List[Int]):Double=
  {
    var cont_categorias:Double=0
    var poneracion:Double=0
    for(categoria <- palabrasclave_libro)
    {
      var index:Int=palabrasclave_lector.indexOf(categoria)
      if(!index.equals(-1)){
        cont_categorias+=1
        poneracion+=poneracion_lector(index)/poneracion_lector.sum
      }
    }
    poneracion=poneracion*(cont_categorias/palabrasclave_libro.length)*poneracion_palabra_clave
    return poneracion;
  }
  
  
}