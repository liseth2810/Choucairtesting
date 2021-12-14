#language: es
#Author: Liseth Yamile Troncoso
Característica: Proceso de Compras.
  Como usuario del portal de compras de ropa New Experience
  Necesito seleccionar prendas del catalogo
  Para realizar la compra de los productos seleccionados

  @e2e
  Escenario: Realizar compra de productos.
    Dado que liseth inicia sesion correctamente
      | usuario           | contrasena |
      | jared@hotmail.com | az22az22   |
    Cuando agrega productos al carrito
      | categoria | prenda                      | precio |
      | Dresses   | Printed Chiffon Dress       | 16.40  |
      | T-shirts  | Faded Short Sleeve T-shirts | 16.51  |
    Y realiza el proceso de compras
    Entonces liseth puede visualizar que su pedido esta completado
    Y vissualiza el precio total a pagar
