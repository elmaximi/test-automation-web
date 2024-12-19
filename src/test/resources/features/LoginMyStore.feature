#language: es
@testMyStore
#Feature: Product - Store
Característica: Login
  Yo, como usuario
  Quiero, tener una opción para iniciar sesión
  Para ver todos los items

  @testLogin
  Escenario: Validación del precio de un producto
    Dado estoy en la página de la tienda
    Y me logueo con mi usuario "elmaximi26@gmail.com" y clave "Serpens1997_"
    Cuando navego a la categoria "Clothes" y subcategoria "Men"
    Y agrego 2 unidades del primer producto al carrito
    Entonces valido en el popup la confirmación del producto agregado
    Y valido en el popup que el monto total sea calculado correctamente
    Cuando finalizo la compra
    Entonces valido el titulo de la pagina del carrito
    Y vuelvo a validar el calculo de precios en el carrito