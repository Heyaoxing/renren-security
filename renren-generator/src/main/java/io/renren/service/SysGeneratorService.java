package io.renren.service;

import io.renren.dao.SysGeneratorDao;
import io.renren.utils.GenUtils;
import org.apache.commons.io.IOUtils;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * 代码生成器
 * 
 * @author
 * @email
 * @date 2016年12月19日 下午3:33:38
 */
@Service
public class SysGeneratorService {
	@Autowired
	private SysGeneratorDao sysGeneratorDao;

	public List<Map<String, Object>> queryList(Map<String, Object> map) {
		return sysGeneratorDao.queryList(map);
	}

	public int queryTotal(Map<String, Object> map) {
		return sysGeneratorDao.queryTotal(map);
	}

	public Map<String, String> queryTable(String tableName) {
		return sysGeneratorDao.queryTable(tableName);
	}

	public List<Map<String, String>> queryColumns(String tableName) {
		return sysGeneratorDao.queryColumns(tableName);
	}

	public byte[] generatorCode(String[] tableNames) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ZipOutputStream zip = new ZipOutputStream(outputStream);
		//generatorTemplete(zip);
		for(String tableName : tableNames){
			//查询表信息
			Map<String, String> table = queryTable(tableName);
			//查询列信息
			List<Map<String, String>> columns = queryColumns(tableName);
			//生成代码
			GenUtils.generatorCode(table, columns, zip);
		}
		IOUtils.closeQuietly(zip);
		return outputStream.toByteArray();
	}

	private void generatorTemplete(ZipOutputStream zip){
		try {
			String fileName="E:"+File.separator+"renren-admin.zip";
			ZipFile war = new ZipFile(fileName);
			Enumeration<? extends ZipEntry> entries = war.getEntries();
			while (entries.hasMoreElements()) {
				ZipEntry e = entries.nextElement();
				System.out.println("copy: " + e.getName());
				zip.putNextEntry(e);
				if (!e.isDirectory()) {
					IOUtils.copy(war.getInputStream(e),zip);
				}
				zip.closeEntry();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
