package br.com.petshow.util;

import java.io.File;
import java.io.IOException;
import br.com.petshow.model.Entidade;
import br.com.petshow.role.RoleParametros;

public class FileUtil {
	
	
	//private static String repoPath = RoleParametros.paramRepoFiles;
	/**
	 * Obtem um objeto java.io.File do diretorio resources
	 * @param path
	 * @return
	 */
	public File getFromResources(String path) {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(path).getFile());
		return file;
	}

	public static File checkAndCreateTheImagesServerRepository(Entidade entidade) {
		String pathname = getPathName(entidade);
		File file = new File(RoleParametros.paramRepoFiles+pathname);
		if(!file.exists()){
			file.mkdirs();
		}
		return file;
	}

	private static String getPathName(Entidade entidade) {
		String pathname = File.separator+entidade.getClass().getTypeName().replace("br.com.petshow.model.", "")+File.separator+entidade.getId();
		return pathname;
	}
	
	public static String saveCertificateOnFileSystem(Entidade entidade,String imgBase64) {
		if(imgBase64 != null && imgBase64.trim().isEmpty() == false){
			try {
				File file = checkAndCreateTheImagesServerRepository(entidade);
				String fileName = HelperUniqueID.get()+".jpg";
				File fileImage = new File(file.getAbsolutePath()+File.separator+fileName);
				HelperBase64.toFile(imgBase64, fileImage);
				return RoleParametros.paramSiteBaseUrl+VariableUtil.docBaseRepoFiles +getPathName(entidade).replaceAll(File.separator, "/")+"/"+fileName;
			} catch (IOException e) {
				e.printStackTrace();
				return "";
			}
		}
		return "";
	}
}
