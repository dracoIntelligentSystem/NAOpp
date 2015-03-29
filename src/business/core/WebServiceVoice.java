package business.core;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.MarshalBase64;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;



public class WebServiceVoice {
	private String NAMESPACE = "http://android";
	private String SOAP_ACTION = "http://android/uploadFile";
	// NAMESPACE + method name
	@SuppressWarnings("unused")
	private String ip ="193.204.187.73:81";
	private String localhost="127.0.0.1:8080";
	final String URL = "http://"+localhost+"/VOCEWebService/services/Android";

	private String METHOD_NAME = "uploadFile";
	private String METHOD_NAME2 = "getArousal";
	private String SOAP_ACTION2 = "http://android/getArousal";
	private String METHOD_NAME3 = "getValence";
	private String SOAP_ACTION3 = "http://android/getValence";
	private String METHOD_NAME4 = "getEmotion";
	private String SOAP_ACTION4 = "http://android/getEmotion";
	private String METHOD_NAME5 = "writeResult";
	private String SOAP_ACTION5 = "http://android/writeResult";
	private String METHOD_NAME6 = "getResult";
	private String SOAP_ACTION6 = "http://android/getResult";

	private String emotion = null,pathfilewav="C:\\Copy\\eclipse\\workspace\\WebPC\\a.wav";
	
	public WebServiceVoice() {
		
	}

	@SuppressWarnings("resource")
	public static byte[] getBytesFromFile(File file) throws IOException {
		InputStream is = new FileInputStream(file);

		// Get the size of the file
		long length = file.length();

		// You cannot create an array using a long type.
		// It needs to be an int type.
		// Before converting to an int type, check
		// to ensure that file is not larger than Integer.MAX_VALUE.
		if (length > Integer.MAX_VALUE) {
			// File is too large
		}

		// Create the byte array to hold the data
		byte[] bytes = new byte[(int)length];

		// Read in the bytes
		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length
				&& (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
			offset += numRead;
		}

		// Ensure all the bytes have been read in
		if (offset < bytes.length) {
			throw new IOException("Could not completely read file "+file.getName());
		}

		// Close the input stream and return bytes
		is.close();
		return bytes;
	}


	public void get3() throws IOException{

		File source_for_byte=new File(pathfilewav);
		byte[] temp = new byte[(int) source_for_byte.length()];
		temp=getBytesFromFile(source_for_byte);
		//MODIFICARE L'ARRAY
		String fileName=pathfilewav.split("\\")[pathfilewav.split("\\").length-1];

		try {
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);//uploadFile
			request.addProperty("wavbite",temp);
			request.addProperty("fileName",fileName);

			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

			new MarshalBase64().register(envelope); // serialization
			envelope.dotNet = true;
			envelope.setOutputSoapObject(request);
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
			androidHttpTransport.call(SOAP_ACTION, envelope);
			String result = (String) envelope.getResponse();
			System.out.println(result);

		} catch (Exception E) {
			E.printStackTrace();
			System.out.println("ERROR:" + E.getClass().getName() + ":" + E.getMessage());
		}

		try {
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME2); //getArousal
			request.addProperty("fileName",fileName);

			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER11);

			new MarshalBase64().register(envelope); // serialization
			envelope.dotNet = true;
			envelope.setOutputSoapObject(request);
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
			androidHttpTransport.call(SOAP_ACTION2, envelope);
			String result = (String) envelope.getResponse();
			System.out.println("Arousal:   "+ result);

		} catch (Exception E) {
			E.printStackTrace();
			System.out.println("ERROR:" + E.getClass().getName() + ":" + E.getMessage());
		}



		try {
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME3); //getValence
			request.addProperty("fileName",fileName);

			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER11);

			new MarshalBase64().register(envelope); // serialization
			envelope.dotNet = true;
			envelope.setOutputSoapObject(request);
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
			androidHttpTransport.call(SOAP_ACTION3, envelope);
			String result = (String) envelope.getResponse();
			System.out.println("Valence:   "+ result);

		} catch (Exception E) {
			E.printStackTrace();
			System.out.println("ERROR:" + E.getClass().getName() + ":" + E.getMessage());
		}

		try {
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME4);//getEmotion
			request.addProperty("fileName",fileName);

			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER11);

			new MarshalBase64().register(envelope); // serialization
			envelope.dotNet = true;
			envelope.setOutputSoapObject(request);
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
			androidHttpTransport.call(SOAP_ACTION4, envelope);
			emotion = (String) envelope.getResponse();
			System.out.println("Emotion:   "+ emotion);

		} catch (Exception E) {
			E.printStackTrace();
			System.out.println("ERROR:" + E.getClass().getName() + ":" + E.getMessage());
		}



		try {
			String testo=fileName+" "+emotion+" "+"Vero"; 

			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME5); //writeResult
			request.addProperty("fileName",testo);

			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER11);

			new MarshalBase64().register(envelope); // serialization
			envelope.dotNet = true;
			envelope.setOutputSoapObject(request);
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
			androidHttpTransport.call(SOAP_ACTION5, envelope);
			String result = (String) envelope.getResponse();
			System.out.println(result);

		} catch (Exception E) {
			E.printStackTrace();
			System.out.println("ERROR:" + E.getClass().getName() + ":" + E.getMessage());
		}


		try {
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME6);//getResult

			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER11);

			new MarshalBase64().register(envelope); // serialization
			envelope.dotNet = true;
			envelope.setOutputSoapObject(request);
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
			androidHttpTransport.call(SOAP_ACTION6, envelope);
			Object result = envelope.getResponse();
			byte[] x=(byte[]) result;

			try
			{
				if(x==null){
					System.out.println("File inesistente!!");
				}
				else{
					File dstFile = new File("test.txt");
					FileOutputStream out = new FileOutputStream(dstFile);
					out.write(x, 0, x.length);
					out.close(); 
				}
			}
			catch (IOException e)
			{
				System.out.println("IOException : " + e);
			}


		} catch (Exception E) {
			E.printStackTrace();
			System.out.println("ERROR:" + E.getClass().getName() + ":" + E.getMessage());
		}


	}

	//	public static void main(String[] args) throws IOException{
	//		
	//		Pc a=new Pc();
	//		a.get3();
	//		//a.get();
	//		//a.get2();
	//		//a.get3();
	//		
	//	}

}

