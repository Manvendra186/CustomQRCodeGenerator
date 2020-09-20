import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * @author Manvendra Rai
 *
 */
public class Generator {
	private static final String QR_IMAGE_FILE_PATH = System.getProperty("user.dir");

	/**
	 * 
	 */
	public Generator() {
	}

	/**
	 * @param args
	 * @throws IOException 
	 * @throws WriterException 
	 */
	public static void main(String[] args) throws WriterException, IOException {
		String customeString = "QR code generator by Manvendra Rai";
		generateQRCodeImage(customeString, 240, 240, QR_IMAGE_FILE_PATH);

	}

	/**
	 * This method will generate a QR.png file and when you scan the QR you will get
	 * your customized string used while creating it
	 * 
	 * @param text
	 * @param width
	 * @param height
	 * @param filePath
	 * @throws WriterException
	 * @throws IOException
	 */
	public static void generateQRCodeImage(String text, int width, int height, String filePath)
			throws WriterException, IOException {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

		Path path = FileSystems.getDefault().getPath(filePath);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
	}
}
