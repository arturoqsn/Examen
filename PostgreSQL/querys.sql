--SELECT "Producto", "Nombre", "Precio" FROM public."Productos";

--2.-Mostrar el número de ventas de cada producto, ordenado de más a menos ventas.
--select Pr."Producto", Pr"Nombre", count(Vt."Producto") "Numero de ventas" from public."Productos" Pr
--	LEFT JOIN public."Venta" Vt ON Pr."Producto" = Vt."Producto" Group by Pr."Producto", Pr."Nombre" Order by count(Vt."Producto") DESC

--3.-Obtener un informe completo de ventas, indicando el nombre del cajero que realizo la venta, nombre y precios
--de los productos vendidos, y el piso en el que se encuentra la máquina registradora donde se realizó la venta.
--SELECT "NomApels", "Nombre", "Precio", "Piso" From public."Venta" Vt,
--		public."Cajeros" Cr, public."Productos" Pr, public."Maquinas_Registradoras" Mr
--	where Vt."Cajero" = Cr."Cajero" 
--	AND Vt."Producto" = Pr."Producto"
--	AND Vt."Maquina" = Mr."Maquina"

--4.-Obtener las ventas totales realizadas en cada piso.
--SELECT Mr."Piso", SUM(Pr."Precio") "Venta total" from public."Venta" Vt,
--	public."Productos" Pr, public."Maquinas_Registradoras" Mr 
--	Where Vt."Producto" = Pr."Producto"
--	AND Vt."Maquina" = Mr."Maquina"
--	Group by Mr."Piso"

--5.-Obtener el código y nombre de cada cajero junto con el importe total de sus ventas.
Select Cr."Cajero", Cr."NomApels", SUM(Pr."Precio") "Importe total" from public."Productos" Pr 
	inner Join public."Cajeros" Cr Left Join public."Venta" Vt On Vt."Cajero" = Cr."Cajero" 
	On Vt."Producto" = Pr."Producto" Group by Cr."Cajero", Cr."NomApels"
	
