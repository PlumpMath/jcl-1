package com.witwall.jcl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ResourceConverter {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) {

		if(args.length!=3)
		{
			System.out.println("Usage:");
			System.out.println("java ResourceConverter resourcePath javaPath packageName");
			System.out.println("example:");
			System.out.println("java ResourceConverter graphics.zip SwtResource.java org.eclipse.swt.examples.graphics");
			return;
		}

		String filename=args[0];/*"E:\\JCGO\\java\\swt\\graphics\\graphics.zip"*/;
		File f=new File(filename);
		
		try {
			String res=Base64.encodeFromFile(filename);
			File out=new File(args[1]);
			FileWriter fw=new FileWriter(out);//("E:\\JCGO\\java\\common\\com\\witwall\\jcl\\SwtResource.java");
			String baseName=out.getName().replaceFirst("[.][^.]+$", "");
			String packageName=args[2];
			
/*			fw.write("import xeus.jcl.JarClassLoader;\n");
			fw.write("import com.witwall.Base64;\n");
			fw.write("import java.io.ByteArrayInputStream;\n");			
			fw.write("public class iTextResource {\n");
			fw.write("\tprivate static String res=\""+res+"\";\n");
			fw.write("\n");
			fw.write("\tpublic static init(){\n");
			fw.write("\t\tbyte[] buffer=Base64.decode(res);\n");
			fw.write("\t\tByteArrayInputStream bis=new ByteArrayInputStream(buffer);\n");
			fw.write("\t\tJarClassLoader jcl = new JarClassLoader();\n");
			fw.write("\t\ttry {\n");
			fw.write("\t\t\tjcl.add(bis);\n");
			fw.write("\t\t} catch (IOException e) {\n");
			fw.write("\t\t\tSystem.out.println(\"Could not find resource file:"+f.getName()+"\");\n");
			fw.write("\t\t}\n");
			
			fw.write("\t}\n");
			
			fw.write("}\n\n");*/
			fw.write("package "+packageName+";\n");
			fw.write("\n");
			fw.write("import xeus.jcl.JarClassLoader;\n");
			fw.write("import com.witwall.jcl.Base64;\n");
			fw.write("import java.io.ByteArrayInputStream;\n");
			fw.write("import java.io.IOException;\n");
/*			fw.write("import java.net.URL;\n");
			fw.write("import java.net.URLClassLoader;\n");*/
			fw.write("\n");
			fw.write("\n");
			fw.write("public class "+baseName+" {\n");
			
			fw.write("\n");
			fw.write("	public  static void init(){\n");
			fw.write("		try {			\n");
			fw.write("			byte[] buffer=Base64.decode(res);\n");
			fw.write("			ByteArrayInputStream bis=new ByteArrayInputStream(buffer);\n");
			fw.write("			JarClassLoader jcl = new JarClassLoader();\n");
			fw.write("			jcl.add(bis);		\n");
			fw.write("			Thread.currentThread().setContextClassLoader(jcl);\n");
			fw.write("		} catch (IOException e) {\n");
			fw.write("			System.out.println(\"Could not find resource file:"+f.getName()+"\");\n");
			fw.write("		}\n");

			
/*			fw.write("		System.setProperty(\"javax.xml.parsers.DocumentBuilderFactor\", \"gnu.xml.dom.DomDocumentBuilderFactory\");\n");
			fw.write("		System.setProperty(\"javax.xml.parsers.SAXParserFactory\", \"gnu.xml.stream.SAXParserFactory\");\n");
			fw.write("		System.setProperty(\"javax.xml.parsers.TransformerFactory\", \"gnu.xml.transform.TransformerFactoryImpl\");\n");
			fw.write("		System.setProperty(\"org.relaxng.datatype.DatatypeLibraryFactory\", \"gnu.xml.validation.datatype.TypeLibraryFactory\");\n");
			fw.write("		System.setProperty(\"org.xml.sax.driver\", \"gnu.xml.stream.SAXParser\");\n");*/
			
			fw.write("	}\n");			
			fw.write("	private static String res=\""+res+"\";\n");
			fw.write("}\n");			
			fw.write("\n");			
			fw.close();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}


}
