update orden
set placa = :placa,
	fecha_ingreso = :fechaIngreso,
	fecha_salida = :fechaSalida,
	valor_total = :valorTotal
where id_orden = :idOrden