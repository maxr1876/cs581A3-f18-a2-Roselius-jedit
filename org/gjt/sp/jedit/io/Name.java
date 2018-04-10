package org.gjt.sp.jedit.io;

import java.io.File;

import org.gjt.sp.jedit.MiscUtilities;

public class Name {

	static String getFileName(String path)
	{
		if(path.equals("/"))
			return path;

		while(path.endsWith("/") || path.endsWith(File.separator))
			path = path.substring(0,path.length() - 1);

		int index = Math.max(path.lastIndexOf('/'),
			path.lastIndexOf(File.separatorChar));
		if(index == -1)
			index = path.indexOf(':');

		// don't want getFileName("roots:") to return ""
		if(index == -1 || index == path.length() - 1)
			return path;

		return path.substring(index + 1);
	}
	
	static String getParentOfPath(String path)
	{
		// ignore last character of path to properly handle
		// paths like /foo/bar/
		int lastIndex = path.length() - 1;
		while(lastIndex > 0
			&& (path.charAt(lastIndex) == File.separatorChar
			|| path.charAt(lastIndex) == '/'))
		{
			lastIndex--;
		}

		int count = Math.max(0,lastIndex);
		int index = path.lastIndexOf(File.separatorChar,count);
		if(index == -1)
			index = path.lastIndexOf('/',count);
		if(index == -1)
		{
			// this ensures that getFileParent("protocol:"), for
			// example, is "protocol:" and not "".
			index = path.lastIndexOf(':');
		}

		return path.substring(0,index + 1);
	}
	
	static String getTwoStageSaveName(String path)
	{
		return MiscUtilities.constructPath(getParentOfPath(path),
			'#' + getFileName(path) + "#save#");
	}
}