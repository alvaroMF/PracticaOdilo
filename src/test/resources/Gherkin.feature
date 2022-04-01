Feature: Adidas

  Scenario: Agregar producto al carrito y comprar sin Email
    Given Estando en la pagina inicial de Adidas
    When Introducimos "Ultraboost 22" en el campo de busqueda
    And Pulsamos la tecla Intro
    Then Se muestra la pantalla de busqueda
    When Seleccionamos "Mujer" en el filtro de Sexo
    And Si se muestra, cerrar PopUp de suscripcion
    And Seleccionamos "Running" en el filtro Deportes
    And Seleccionamos "Carretera" en el filtro Superficie
    Then Se muestran los resultados con los filtros indicados
    When Seleccionamos el tercer resultado
    Then Se muestra el detalle del producto
    When Hacemos click en Guia de tallas
    Then Se muestra la guia de tallas
    When Hacemos click en Como saber tu talla
    And Hacemos click en Volver al principio
    And Hacemos click en Pulgadas
    Then Se muestra la tabla en Pulgadas
    When Hacemos click en CM
    Then Se muestra la tabla en Centimetros
    When Hacemos click en X para cerrar el PopUp
    And Hacemos Scroll hasta Valoraciones y Reseñas
    Then Se muestra el apartado Valoraciones y Reseñas
    When Hacemos click en Escribir una reseña
    Then Se muestra el formulario para escribir una reseña
    When  Indicamos "5" estrellas en Valoracion general
    And Indicamos "Si" en Recomendacion del producto
    And Introducimos "Me encantan, con estas zapatillas corro las maratones y ni me entero, la verdad." en el cuadro de texto de reseña
    And Introducimos "Muy buenas" en el resumen de la reseña
    And Indicamos la opcion numero "3" en Acorde con su talla
    And Indicamos la opcion numero "3" en Ancho adecuado de la horma
    And Indicamos "3" estrellas en Valoracion de comodidad
    And Indicamos "4" estrellas en Valoracion de calidad
    And Subimos una imagen del producto
    Then Comprobamos que la imagen se ha subido
    When Introducimos "Ibai" en el campo Apodo
    And Hacemos click en Enviar Reseña
    Then Devuelve un error ya que no hemos introducido el email

#    And Seleccionamos la talla "40"
#    And Hacemos click en Añadir al carrito
#    Then Se muestra un PopUp indicando que se ha añadido al carrito
#    When Hacemos click en Ver Carrito
#    Then Se muestra la pantalla Tu carrito
#    When Hacemos click en sesenta dias de devolucion y cambio
#    Then Se abre el PopUp Devoluciones y Reembolsos
#    When Hacemos click en la X àra cerrar el PopUp
#    And Hacemos click en Continuar
#    Then Se muestra el formulario de compra
#    When Introducimos "Ibai" en el campo Nombre
#    And Introducimos "Llanos" en el campo Apellidos
#    And Introducimos "Avenida de los Streamers, 8" en el campo Calle
#    And Introducimos "80085" en el campo Codigo postal
#    And Introducimos "Barcelona" en el campo Barcelona
#    And Hacemos click en Revisar y Pagar
#    Then Se muestra un mensaje de error indicando que es obligatorio el email
