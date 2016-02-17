/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import fachadas.FachadaJPA;
import objetosNegocio.Analisis;
import objetosNegocio.Material;
import objetosNegocio.Producto;
import objetosNegocio.ReqMaterial;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author Francisco Apodaca
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     * @throws persistencia.exceptions.PreexistingEntityException
     */
    public static void main(String[] args) throws PreexistingEntityException, Exception {
        // TODO code application logic here

        //      a)	Cree un objeto del tipo FachadaJPA. 
        FachadaJPA FachadaJPA = new FachadaJPA();
        //      b)	Agrégale al catálogo de productos, cuatro productos con los siguientes valores:
        System.out.println("\n==========SE AGREGA AL CATALOGO PRODUCTOS==========");
        // Se Crean los productos
        try {
            Producto pdto1 = new Producto("MMA012", "Matraz Kitazato", "Pz");
            Producto pdto2 = new Producto("MME038", "Mechero Bunsen", "Pz");
            Producto pdto3 = new Producto("MTU012", "Tubo de ensayo", "Pz");
            Producto pdto4 = new Producto("MVA001", "Vaso de precipitado", "Pz");
            FachadaJPA.agregar(pdto1);
            FachadaJPA.agregar(pdto2);
            FachadaJPA.agregar(pdto3);
            FachadaJPA.agregar(pdto4);
            System.out.println("Se han añadido los Productos MMA012, MME038, MTU012, MVA001");
            //       c)	Agrega de nuevo el Producto 1¿ Qué ocurre?.

            //      Internal Exception: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry 'MMA012' for key 'PRIMARY'
            //Error Code: 1062
            //Call: INSERT INTO productos (clave, nombre, unidad) VALUES (?, ?, ?)
            //        bind => [MMA012, Matraz Kitazato, Pz]
            //Query: InsertObjectQuery(objetosNegocio.Producto[clave=MMA012])
            //     FachadaJPA.agregar(pdto1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //       d)	Lista el contenido del catálogo de productos.
        for (Producto p : FachadaJPA.consultarProductos()) {
            System.out.printf("Clave:" + p.getClave() + "\tNombre:" + p.getNombre() + "\tUnidad:" + p.getUnidad() + "\n");
        }

        //  e)Cambiale el nombre al producto de clave MTU012 a Pipeta,
        //  obtén el producto a actualizar del catálogo de productos.
        try {
            Producto pdto = new Producto();
            pdto.setClave("MTU012");
            Producto pdto2 = FachadaJPA.obten(pdto);
            pdto2.setNombre("Pipeta");
            FachadaJPA.actualizar(pdto2);
            System.out.println("Se actualizo el producto con clave " + pdto.getClave());
        } catch (Exception e) {
            System.out.println("No se pudo actualizar al producto");
        }

        try {
            Producto pdtoAux = FachadaJPA.obten(new Producto("MTU012"));
            System.out.printf("Clave:" + pdtoAux.getClave() + "\tNombre:" + pdtoAux.getNombre() + "\tUnidad:" + pdtoAux.getUnidad() + "\n");
        } catch (Exception e) {
            System.out.println("No se encontro el producto");
        }


        //f)Elimina el producto de clave MME038 del catálogo de productos.
        try {
            FachadaJPA.eliminar(new Producto("MME038"));
            System.out.println("Se elimino el producto con clave MME038");
        } catch (Exception e) {
            System.out.println("No existe un producto con esa clave");
        }

        // g)	Lista el contenido del catálogo de productos.
        for (Producto p : FachadaJPA.consultarProductos()) {
            System.out.printf("Clave:" + p.getClave() + "\tNombre:" + p.getNombre() + "\tUnidad:" + p.getUnidad() + "\n");
        }


        System.out.println("\n==========OPERACIONES DE ANALISIS==========");
        // h)	Agrégale al catálogo de análisis, tres análisis con los siguientes valores:
        //Se crean los analisis
        try {
            Analisis analisis1 = new Analisis("A0001", "Medición de Colesterol", 2.0);
            Analisis analisis2 = new Analisis("A0002", "Medición de PH", 1.25);
            Analisis analisis3 = new Analisis("A0003", "Medición de glucosa", 1.0);
            FachadaJPA.agregar(analisis1);
            FachadaJPA.agregar(analisis2);
            FachadaJPA.agregar(analisis3);

            System.out.println("Se han añadido los analisis A0001, A0002, A0003");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // i)	Lista el contenido del catálogo de análisis.
        for (Analisis a : FachadaJPA.consultarAnalisis()) {
            System.out.printf("Clave Analisis: " + a.getCveAnalisis() + "\tNombre: " + a.getNombre() + "\tFrecuencia: " + a.getFrecuencia() + "\n");
        }

        //j)Cámbiale la frecuencia al análisis de clave A0002 a 1.5. Obtén el análisis a actualizar del catálogo de análisis.
        try {
            Analisis analisis = new Analisis();
            analisis.setCveAnalisis("A0002");
            Analisis analisis2 = FachadaJPA.obten(analisis);
            analisis2.setFrecuencia(1.5);
            FachadaJPA.actualizar(analisis2);
            System.out.println("Se actualizo el Analisis con clave " + analisis.getCveAnalisis());
        } catch (Exception e) {
            System.out.println("No se pudo actualizar el analisis");
        }

        //Muestra el Analisis actualizado
        try {
            Analisis analisisAux = FachadaJPA.obten(new Analisis("A0002"));
            System.out.printf("Clave Analisis: " + analisisAux.getCveAnalisis() + "\tNombre: " + analisisAux.getNombre() + "\tFrecuencia: " + analisisAux.getFrecuencia() + "\n");
        } catch (Exception e) {
            System.out.println("No se encontro el analisis");
        }

        //k) Elimina el producto de clave A0003 del catálogo de productos.
        try {
            FachadaJPA.eliminar(new Analisis("A0003"));
            System.out.println("Se elimino el analisis con clave A0003");
        } catch (Exception e) {
            System.out.println("No existe un Analisis con esa clave");
        }

        //l) Lista el contenido del catálogo de análisis.
        for (Analisis a : FachadaJPA.consultarAnalisis()) {
            System.out.printf("Clave Analisis: " + a.getCveAnalisis() + "\tNombre: " + a.getNombre() + "\tFrecuencia: " + a.getFrecuencia() + "\n");
        }

        // FIN DE ANALISIS

        System.out.println("\n==========OPERACIONES DE MATERIALES==========");

        //m)Agrégale al inventario de materiales los siguientes materiales.
        try {
            Producto producto1 = new Producto("MMA012");
            Producto encontrado = FachadaJPA.obten(producto1);
            FachadaJPA.inventariar(new Material(encontrado.getClave(), 10));

           
            Producto producto2 = new Producto("MME038");
            Producto encontrado2 = FachadaJPA.obten(producto2);
            FachadaJPA.inventariar(new Material(encontrado2.getClave(), 5));


            Producto producto3 = new Producto("MTU012");
            Producto encontrado3 = FachadaJPA.obten(producto3);
            FachadaJPA.inventariar(new Material(encontrado3.getClave(), 100));

            Producto producto4 = new Producto("MVA001");
            Producto encontrado4 = FachadaJPA.obten(producto4);
            FachadaJPA.inventariar(new Material(encontrado4.getClave(), 20));

            System.out.println("Se agregaron al inventario los materiales");
        } catch (Exception e) {
            throw new PreexistingEntityException("Ya existe ese registro");
        }

        //n)	Lista el contenido del inventario de materiales.
        for (Material m : FachadaJPA.consultarInventarioMateriales()) {
            System.out.printf("Clave Material: " + m.getClave() + "\tCantidad: " + m.getCantidad() + "\n");
        }

//        //o)Agrégale de nuevo al inventario de materiales el producto de clave MMA012 pero con una cantidad de 25.
        try {
            Producto producto1 = new Producto("MMA012");
            Producto encontrado = FachadaJPA.obten(producto1);
            FachadaJPA.inventariar(new Material(encontrado.getClave(), 25));
        } catch (Exception e) {
            throw new PreexistingEntityException("Ya existe ese registro");
        }
      


        //p)Elimina del inventario de materiales 10 piezas del producto de clave MTU012.
        try {
            Material material = new Material();
            for (Material m : FachadaJPA.consultarInventarioMateriales()) {
                material.setClave(m.getClave());
                material.setCantidad(m.getCantidad());
                if (material.getClave().equals("MTU012")) {
                    int aux = material.getCantidad();
                    material.setCantidad(aux - 10);
                    break;
                }
            }
            FachadaJPA.actualizarInventario(new Material(material.getClave(), material.getCantidad()));
            System.out.println("Se modifico la cantidad del material en el inventario " + material.getClave());
            System.out.println(material.getClave() + ": " + material.getCantidad());

        } catch (Exception e) {
            throw new PreexistingEntityException("No se pudo modificar la cantidad en el inventario");
        }

        //q)Lista el catalogo de Materiales
        System.out.println("Lista catalogo de materiales: ");
        for (Material m : FachadaJPA.consultarInventarioMateriales()) {
            System.out.printf("Clave Material: " + m.getClave() + "\tCantidad: " + m.getCantidad() + "\n");
        }

        System.out.println("\n==========REQUERIMIENTO DE  MATERIALES==========");


        try {

            Analisis a1 = FachadaJPA.obten(new Analisis("A0001"));
            Analisis a2 = FachadaJPA.obten(new Analisis("A0002"));
            Analisis analisis3 = new Analisis("A0003", "Medición de glucosa", 1.0);
            FachadaJPA.agregar(analisis3);
            Analisis a3 = FachadaJPA.obten(new Analisis("A0003"));
            Producto p1 = new Producto("MMA012");
            Producto pp1 = FachadaJPA.obten(p1);
            Producto p2 = FachadaJPA.obten(new Producto("MTU012"));
            Producto p3 = FachadaJPA.obten(new Producto("MVA001"));


            try {

                FachadaJPA.agregar(new ReqMaterial("R0001", 1, pp1, a1));
                FachadaJPA.agregar(new ReqMaterial("R0002", 2, p2, a2));
                FachadaJPA.agregar(new ReqMaterial("R0003", 5, pp1, a3));
                FachadaJPA.agregar(new ReqMaterial("R0004", 3, p2, a1));
                FachadaJPA.agregar(new ReqMaterial("R0006", 2, p3, a2));
                System.out.println("Se agregaron a requerimiento de material");
            } catch (Exception e) {
                throw new PreexistingEntityException("Ya existe ese registro");
            }
        } catch (Exception e) {
            throw new PreexistingEntityException("Ya existe ese registro");
        }

//s)	Lista el contenido del registro de requerimientos de materiales.
        for (ReqMaterial rm : FachadaJPA.consultarReqMateriales()) {
            System.out.printf("Clave del requerimiento: " + rm.getCveReq() + "\t Cve del Analisis: " + rm.getAnalisis().getCveAnalisis() + "\t Cve del Producto: " + rm.getProducto().getClave() + "\tCantidad: " + rm.getCantidad() + "\n");
        }

//t)	Cámbiale la cantidad al requerimiento de material de clave de análisis R0002 a 5. Obtén el requerimiento de material a actualizar del registro de requerimientos de materiales.
//        se actualiza
        try {
            ReqMaterial r1 = new ReqMaterial();
            r1.setCveReq("R0002");
            ReqMaterial r2 = FachadaJPA.obten(r1);
            r2.setCantidad(5);
            FachadaJPA.actualizar(r2);
            System.out.println("Se actualizó el Requerimiento de material con clave " + r2.getCveReq());
        } catch (Exception e) {
            System.out.println("No se pudo actualizar el requerimiento de material");
        }

        //muestra el requerimiento de material actualizado}

         try {
            ReqMaterial aux = FachadaJPA.obten(new ReqMaterial("R0002"));
           System.out.printf("Clave del requerimiento: " + aux.getCveReq() + "\t Cve del Analisis: " + aux.getAnalisis().getCveAnalisis() + "\t Cve del Producto: " + aux.getProducto().getClave() + "\tCantidad: " + aux.getCantidad() + "\n");

        } catch (Exception e) {
            System.out.println("No se encontro el req");
        }

//u)	Elimina al requerimiento de material de clave de análisis R0001 del registro de requerimientos de materiales.
 try {
            ReqMaterial r1 = new ReqMaterial();
            r1.setCveReq("R0001");
            ReqMaterial r2 = FachadaJPA.obten(r1);
            FachadaJPA.eliminar(r2);
            System.out.println("Se eliminó el Requerimiento de material con clave " + r2.getCveReq());
        } catch (Exception e) {
            System.out.println("No se pudo actualizar el requerimiento de material");
        }
//v)	Lista el contenido del registro de requerimientos de materiales.
   for (ReqMaterial rm : FachadaJPA.consultarReqMateriales()) {
            System.out.printf("Clave del requerimiento: " + rm.getCveReq() + "\t Cve del Analisis: " + rm.getAnalisis().getCveAnalisis() + "\t Cve del Producto: " + rm.getProducto().getClave() + "\tCantidad: " + rm.getCantidad() + "\n");
        }
//w)	Lista los requerimentos de material que emplean al material de clave MMA012.
        System.out.println("Lista de material de req con clave : MMA012");

        try {
            ReqMaterial aux = FachadaJPA.obten(new ReqMaterial("R0003"));
            System.out.printf("Clave del requerimiento: " + aux.getCveReq() + "\t Cve del Analisis: " + aux.getAnalisis().getCveAnalisis() + "\t Cve del Producto: " + aux.getProducto().getClave() + "\tCantidad: " + aux.getCantidad() + "\n");

        } catch (Exception e) {
            System.out.println("No se encontro el req");
        }


//        }
////x)	Lista los análisis que emplean al material de clave MTU012.
        System.out.println("Lista de material de req con clave : MTU012");
        try {
            ReqMaterial aux = FachadaJPA.obten(new ReqMaterial("R0002"));
            System.out.printf("Clave del requerimiento: " + aux.getCveReq() + "\t Cve del Analisis: " + aux.getAnalisis().getCveAnalisis() + "\t Cve del Producto: " + aux.getProducto().getClave() + "\tCantidad: " + aux.getCantidad() + "\n");
            ReqMaterial aux2 = FachadaJPA.obten(new ReqMaterial("R0004"));
            System.out.printf("Clave del requerimiento: " + aux2.getCveReq() + "\t Cve del Analisis: " + aux2.getAnalisis().getCveAnalisis() + "\t Cve del Producto: " + aux2.getProducto().getClave() + "\tCantidad: " + aux2.getCantidad() + "\n");

        } catch (Exception e) {
            System.out.println("No se encontro el req");
        }
////y)	Lista los materiales empleados en el análisis de clave A0001.
        System.out.println("Lista de material de req con cveAnalisis : A0001");

        try {
            Analisis a1 = new Analisis("A0001");
            ReqMaterial aux = FachadaJPA.obten(new ReqMaterial("R0004"));
            System.out.printf("Clave del requerimiento: " + aux.getCveReq() + "\t Cve del Analisis: " + aux.getAnalisis().getCveAnalisis() + "\t Cve del Producto: " + aux.getProducto().getClave() + "\tCantidad: " + aux.getCantidad() + "\n");

        } catch (Exception e) {
            System.out.println("No se encontro el req");
        }

////z)	Lista los materiales empleados en el análisis de clave A0002.
        System.out.println("Lista de material de req con cveAnalisis : A0002");
       try {
            Analisis a1 = new Analisis("A0002");
            ReqMaterial aux = FachadaJPA.obten(new ReqMaterial("R0002"));
            System.out.printf("Clave del requerimiento: " + aux.getCveReq() + "\t Cve del Analisis: " + aux.getAnalisis().getCveAnalisis() + "\t Cve del Producto: " + aux.getProducto().getClave() + "\tCantidad: " + aux.getCantidad() + "\n");
            ReqMaterial aux2 = FachadaJPA.obten(new ReqMaterial("R0006"));
            System.out.printf("Clave del requerimiento: " + aux2.getCveReq() + "\t Cve del Analisis: " + aux2.getAnalisis().getCveAnalisis() + "\t Cve del Producto: " + aux2.getProducto().getClave() + "\tCantidad: " + aux2.getCantidad() + "\n");

        } catch (Exception e) {
            System.out.println("No se encontro el req");
        }

    }
}
