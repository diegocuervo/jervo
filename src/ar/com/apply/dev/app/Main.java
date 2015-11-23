package ar.com.apply.dev.app;


import java.io.File;

import com.essbase.api.base.EssException;
import com.essbase.api.base.IEssBaseObject;
import com.essbase.api.base.IEssIterator;
import com.essbase.api.datasource.IEssCube;
import com.essbase.api.datasource.IEssOlapApplication;
import com.essbase.api.datasource.IEssOlapServer;
import com.essbase.api.domain.IEssAppComponent;
import com.essbase.api.domain.IEssDomain;
import com.essbase.api.session.IEssbase;



public class Main {

	private static int a2;

	public static void main(String[] args)  {
		
		//ODITable[] oTabs;
		Long a;
		DirSize dz = new DirSize();
		a = dz.DirSizeA(new File("C:/Java"));
		System.out.println("C:/Java: " + a + " bytes");
		
		//*************************************
		/*
		HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put(ODIConstants.SERVER, "192.168.182.112");
		hmap.put(ODIConstants.PORT, "13080");
		hmap.put(ODIConstants.USER, "admin");
		hmap.put(ODIConstants.PASSWORD, "hyp3r10n");
		hmap.put(ODIConstants.APPLICATION_NAME, "CVCOSTOs");
		hmap.put(ODIConstants.DATABASE_NAME, "COSTOS");

		IHypAppConnection cnx;
		try {
			cnx = HypAppConnectionFactory.getAppConnection(HypAppConnectionFactory.APP_ESSBASE, hmap);
			
//			cnx.connect();
			oTabs = cnx.getTables();
//			oTabs[0].getTableName().codePointAt(0);

			cnx.hashCode();
		} catch (ODIHAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/


	a2 = getConnectionCount2("admin","hyp3r10n","http://192.168.182.112:13080/aps/JAPI"); 

	System.out.println(a2);
		
		
		
		

	}
	
	public static int getConnectionCount2(String username, String password, String server) {
	    IEssbase essbase = null;
	    IEssDomain dom = null;
	    try {
	        essbase = IEssbase.Home.create(IEssbase.JAPI_VERSION);
	        dom =  essbase.signOn(username, password, false, null, server);

	        IEssIterator apps = dom.getApplications();
	        System.out.println("Appps: " + dom.getCountApplications());
	        int b = dom.getCountOlapServers();
	        int c = dom.getCountEnterpriseServers();
	        IEssOlapServer hapd =  dom.getOlapServer("hyperapd");
	        hapd.connect();
	        IEssIterator applist = hapd.getApplications();
	        
            for (int i=0; i < applist.getCount(); i++) {
            	IEssOlapApplication group = (IEssOlapApplication)applist.getAt(i);
                System.out.println("APP " + i + ": " + group.getName()  + "\n Cubos: " + group.getCountCubes() + "\n UsuariosConectados: " + group.getCountUsersConnected() + "\n Tipo: " + group.getType() + "\n Tipo Almacenamiento: " + group.getDataStorageType()+ "\n Tiempo: " + group.getElapsedAppTime() + "\n AppStatus: " + group.getAppLoadStatus().stringValue() + "\n Peso de Cubos: " + pesoCubos(group.getCubes()));
                }
	        
	        

	        String[] propNames = dom.getPropertyNames();
	        IEssIterator oSrv = dom.getOlapServers();
	        IEssBaseObject[] connectionInfoObjects = apps.getAll();
	        System.out.println("Application count: {}" + applist.getAll().length);
	        return connectionInfoObjects.length;
	    } catch (EssException e) {
	    	System.out.println("Essbase error: {}" +  e.getMessage());
	        return -1;
	    } finally {
	        try {
	            //olapServer.disconnect();
	            essbase.signOff();
	        } catch (EssException e) {
	        }
	    }
	}

	private static int pesoCubos(IEssIterator cubes) {
			int suma = 0;
			try {
				for (int i=0; i < cubes.getCount(); i++) {
					IEssCube iec = (IEssCube)cubes.getAt(i);
					suma += iec.getActualBlockSize() * iec.getTotalBlocks();
				}
			} catch (EssException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return suma;
		
	}


}