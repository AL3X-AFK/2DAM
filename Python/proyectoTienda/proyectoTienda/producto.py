class Producto:
    def __init__(self, producto, categoria, precio, stock, valoracion, proveedor):
        self.producto = producto
        self.categoria = categoria
        self.precio = precio
        self.stock = stock
        self.valoracion = valoracion
        self.proveedor = proveedor

    def to_dict(self):
        return {
            "producto": self.producto,
            "categoria": self.categoria,
            "precio": self.precio,
            "stock": self.stock,
            "valoracion": self.valoracion,
            "proveedor": self.proveedor
        }