	@Test
	public void test03() throws Exception{ //������list����ת��Ϊjson��,����json��������txt�ļ���ȥ		
		List<LSPCenter> readExcelLSP = lspGet.ReadExcelLSP(lsppath);
		Gson gson = new Gson();
		String json = gson.toJson(readExcelLSP);
		File fileText = new File(savePath); //�����ļ�����
		FileWriter fileWriter = new FileWriter(fileText);//���ļ���д����Ϣ
		fileWriter.write(json);     //��jsonд��txt�ļ���ȥ
		fileWriter.close();
		System.out.println(json);		 		
	}
	