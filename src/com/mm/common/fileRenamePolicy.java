package com.mm.common;

import java.io.File;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class fileRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File originFile) {
		String originName = originFile.getName();
		String currentTime = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		int ranNum = (int)((Math.random()*900000000 + 100000000));
		String ext = originName.substring(originName.lastIndexOf("."));
		String changeName = currentTime + ranNum + ext;
		return new File(originFile.getParent(), changeName);
	}
}
