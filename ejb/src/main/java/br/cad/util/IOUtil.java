package br.cad.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * 
 * @author Robson J. P.
 *
 */
public class IOUtil {
	
	/**
	 * Move arquivo. Diretorios nao sao suportados
	 * 
	 * @param source
	 * @param target
	 * @return
	 */
	public static boolean moveFile(File source, File target) {
		if(!source.isFile())
			return false;
		
		//Tenta mover diretamente o arquivo
		if(source.renameTo(target))
			return true;
		
		//Copia por stream, e apos remove o arquivo de origem
		try{
			copyStream(new FileInputStream(source), new FileOutputStream(target));
			source.delete();
			return true;
		}catch(Exception e) {
		}
		return false;
	}
	
	/**
	 * Copia a stream output para a stream output, fechando as duas streans ao final do processo de copia.
	 * 
	 * @param in stream de origem
	 * @param out stream de destino
	 */
	public static void copyStream(InputStream input, OutputStream output) throws IOException {
		// get an channel from the stream  
		final ReadableByteChannel inputChannel = Channels.newChannel(input);
		final WritableByteChannel outputChannel = Channels.newChannel(output);
		// copy the channels  
		fastChannelCopy(inputChannel, outputChannel);
		// closing the channels  
		inputChannel.close();
		outputChannel.close();  
	}	
	
	public static void fastChannelCopy(final ReadableByteChannel src, final WritableByteChannel dest) throws IOException {
		final ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 1024);
		while (src.read(buffer) != -1) {
			// prepare the buffer to be drained
			buffer.flip();
			// write to the channel, may block
			dest.write(buffer);
			// If partial transfer, shift remainder down
			// If buffer is empty, same as doing clear()
			buffer.compact();
		}
		// EOF will leave buffer in fill state
		buffer.flip();
		// make sure the buffer is fully drained.
		while (buffer.hasRemaining()) {
			dest.write(buffer);
		}
	}
	
}
