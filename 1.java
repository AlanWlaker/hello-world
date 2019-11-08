	@Test
	public void test03() throws Exception{ //导出的list集合转换为json串,并将json串保存在txt文件中去		
		List<LSPCenter> readExcelLSP = lspGet.ReadExcelLSP(lsppath);
		Gson gson = new Gson();
		String json = gson.toJson(readExcelLSP);
		File fileText = new File(savePath); //创建文件对象
		FileWriter fileWriter = new FileWriter(fileText);//向文件中写入信息
		fileWriter.write(json);     //将json写入txt文件中去
		fileWriter.close();
		System.out.println(json);		 		
	}
	