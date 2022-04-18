//package com.maan.vehicle.excelHelper;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.maan.life.bean.MPolWordings;
//import com.maan.life.bean.MProdSchApplCond;
//import com.maan.life.bean.MTariffLifeDetails;
//import com.maan.life.dto.MPolwordingsExcelDto;
//import com.maan.life.dto.MProdSchApplConExcelDto;
//import com.maan.life.dto.MTariffLifeDetailsExcelDto;
//import com.maan.life.service.MPolWordingsService;
//import com.maan.life.service.MProdSchApplCondService;
//import com.maan.life.service.MTariffLifeDetailsService;
//import com.maan.life.util.ValidationUtil;
//
//@Service
//public class ExcelHelper {
//
//	@Autowired
//	private MProdSchApplCondService entityService;
//
//	@Autowired
//	private MPolWordingsService mPolWordingsService;
//	
//	@Autowired
//	private MTariffLifeDetailsService tariffLifeService;
//
//	public byte[] downloadExcelConditions(List<MProdSchApplCond> obj) {
//
//		try {
//
//			Resource resource = new ClassPathResource("Condition_Template.xlsx");
//			InputStream fileStream = resource.getInputStream();
//
//			XSSFWorkbook workbook = new XSSFWorkbook(fileStream);
//			XSSFSheet worksheet = workbook.getSheetAt(0);
//			int rowvariable = 1;
//			Cell cell = null;
//			for (MProdSchApplCond newObj : obj) {
//				Row row = worksheet.createRow(rowvariable);
//
//				cell = row.createCell(0);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getPsacSysId()));
//				cell = row.createCell(1);
//				cell.setCellValue(newObj.getPsacProdCode());
//				cell = row.createCell(2);
//				cell.setCellValue(newObj.getPsacCompCode());
//				cell = row.createCell(3);
//				cell.setCellValue(newObj.getPsacSchCode());
//				cell = row.createCell(4);
//				cell.setCellValue(newObj.getPsacCode());
//				cell = row.createCell(5);
//				cell.setCellValue(newObj.getPsacCvrCode());
//				cell = row.createCell(6);
//				cell.setCellValue(newObj.getPsacLvl());
//				cell = row.createCell(7);
//				cell.setCellValue(newObj.getPsacType());
//				cell = row.createCell(8);
//				cell.setCellValue(newObj.getPsacDfltYn());
//				cell = row.createCell(9);
//				cell.setCellValue(newObj.getPsacDesc());
//				cell = row.createCell(10);
//				cell.setCellValue(newObj.getPsacDescBl());
//				cell = row.createCell(11);
//				cell.setCellValue(newObj.getPsacShortDesc());
//				cell = row.createCell(12);
//				cell.setCellValue(newObj.getPsacShortDescBl());
//				cell = row.createCell(13);
//				cell.setCellValue(newObj.getPsacLongDesc());
//				cell = row.createCell(14);
//				cell.setCellValue(newObj.getPsacLongDescBl());
//				cell = row.createCell(15);
//				cell.setCellValue(ValidationUtil.format(newObj.getPsacEffFmDt()));
//				cell = row.createCell(16);
//				cell.setCellValue(ValidationUtil.format(newObj.getPsacEffToDt()));
//				cell = row.createCell(17);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getPsacSrNo()));
//				cell = row.createCell(18);
//				cell.setCellValue(ValidationUtil.format(newObj.getPsacCrDt()));
//				cell = row.createCell(19);
//				cell.setCellValue(newObj.getPsacCrUid());
//				cell = row.createCell(20);
//				cell.setCellValue(ValidationUtil.format(newObj.getPsacUpdDt()));
//				cell = row.createCell(21);
//				cell.setCellValue(newObj.getPsacUpdUid());
//				cell = row.createCell(22);
//				cell.setCellValue(newObj.getPascConvType());
//				cell = row.createCell(23);
//				cell.setCellValue(newObj.getRemarks());
//
//				rowvariable++;
//
//			}
//
//			ByteArrayOutputStream bos = new ByteArrayOutputStream();
//			workbook.write(bos);
//			workbook.close();
//			byte[] barray = bos.toByteArray();
//
//			return barray;
//		}
//
//		catch (Exception e) {
//			throw new RuntimeException("fail to export data to Excel file: " + e.getMessage());
//		}
//
//	}
//
//	public byte[] downloadExcelPolWordings(List<MPolWordings> obj) {
//
//		try {
//
//			Resource resource = new ClassPathResource("Polwordings_Template.xlsx");
//			InputStream fileStream = resource.getInputStream();
//
//			XSSFWorkbook workbook = new XSSFWorkbook(fileStream);
//			XSSFSheet worksheet = workbook.getSheetAt(0);
//			int rowvariable = 1;
//			Cell cell = null;
//			for (MPolWordings newObj : obj) {
//				Row row = worksheet.createRow(rowvariable);
//
//				cell = row.createCell(0);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getPwSysId()));
//				cell = row.createCell(1);
//				cell.setCellValue(newObj.getPwProductCode());
//				cell = row.createCell(2);
//				cell.setCellValue(newObj.getPwWordingType());
//				cell = row.createCell(3);
//				cell.setCellValue(newObj.getPwPageName());
//				cell = row.createCell(4);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getPwPageno()));
//				cell = row.createCell(5);
//				cell.setCellValue(newObj.getPwPageOrder());
//				cell = row.createCell(6);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getPwPageLineNo()));
//				cell = row.createCell(7);
//				cell.setCellValue(newObj.getPwDisplayText1());
//				cell = row.createCell(8);
//				cell.setCellValue(newObj.getPwDisplayText2());
//				cell = row.createCell(9);
//				cell.setCellValue(newObj.getPwDisplayText3());
//				cell = row.createCell(10);
//				cell.setCellValue(newObj.getPwAllignment());
//				cell = row.createCell(11);
//				cell.setCellValue(newObj.getPwFontsize());
//				cell = row.createCell(12);
//				cell.setCellValue(newObj.getPwTextformat());
//				cell = row.createCell(13);
//				cell.setCellValue(newObj.getPwLvl());
//				cell = row.createCell(14);
//				cell.setCellValue(newObj.getPwCoverCode());
//				cell = row.createCell(15);
//				cell.setCellValue(newObj.getPwDynamicColumn1());
//				cell = row.createCell(16);
//				cell.setCellValue(newObj.getPwDynamicColumn2());
//				cell = row.createCell(17);
//				cell.setCellValue(newObj.getPwDynamicColumn3());
//				cell = row.createCell(18);
//				cell.setCellValue(newObj.getRemarks());
//
//				rowvariable++;
//
//			}
//
//			ByteArrayOutputStream bos = new ByteArrayOutputStream();
//			workbook.write(bos);
//			workbook.close();
//			byte[] barray = bos.toByteArray();
//
//			return barray;
//		}
//
//		catch (Exception e) {
//			throw new RuntimeException("fail to export data to Excel file: " + e.getMessage());
//		}
//
//	}
//
//	public MProdSchApplConExcelDto uploadExcelConditions(MultipartFile file, String prodCode, String schCode,
//			String compCode) {
//
//		List<String> errors = null;
//
//		int totalRecords = 0;
//		int uploadRecords = 0;
//		int errorRecords = 0;
//
//		MProdSchApplConExcelDto value = new MProdSchApplConExcelDto();
//
//		List<MProdSchApplCond> list = new ArrayList<MProdSchApplCond>();
//
//		try (XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())) {
//			XSSFSheet worksheet = workbook.getSheetAt(0);
//
//			DataFormatter formatter = new DataFormatter();
//
//			totalRecords = worksheet.getPhysicalNumberOfRows() - 1;
//
//			for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
//
//				MProdSchApplCond mProd = null;
//
//				XSSFRow row = worksheet.getRow(i);
//
//				String psacSysId = formatter.formatCellValue(row.getCell(0));
////				String psacProdCode = formatter.formatCellValue(row.getCell(1));
////				String psacCompCode = formatter.formatCellValue(row.getCell(2));
////				String psacSchCode = formatter.formatCellValue(row.getCell(3));
//				String psacCode = formatter.formatCellValue(row.getCell(4));
//				String psacCvrCode = formatter.formatCellValue(row.getCell(5));
//				String psacLvl = formatter.formatCellValue(row.getCell(6));
//				String psacType = formatter.formatCellValue(row.getCell(7));
//				String psacDfltYn = formatter.formatCellValue(row.getCell(8));
//				String psacDesc = formatter.formatCellValue(row.getCell(9));
//				String psacDescBl = formatter.formatCellValue(row.getCell(10));
//				String psacShortDesc = formatter.formatCellValue(row.getCell(11));
//				String psacShortDescBl = formatter.formatCellValue(row.getCell(12));
//				String psacLongDesc = formatter.formatCellValue(row.getCell(13));
//				String psacLongDescBl = formatter.formatCellValue(row.getCell(14));
//				String psacEffFmDt = formatter.formatCellValue(row.getCell(15));
//				String psacEffToDt = formatter.formatCellValue(row.getCell(16));
//				String psacSrNo = formatter.formatCellValue(row.getCell(17));
//				String pascConvType = formatter.formatCellValue(row.getCell(22));
//
//				errors = new ArrayList<>();
//
//				if (ValidationUtil.isNull(ValidationUtil.convertBigDecimal(psacSysId))) {
//					Optional<MProdSchApplCond> optional = entityService.findByData(psacCode, prodCode, schCode,
//							compCode);
//
//					if (optional.isPresent()) {
//						errors.add("Already Exist");
//					}
//
//				} else {
//
//					Optional<MProdSchApplCond> opt = entityService
//							.findById(ValidationUtil.convertBigDecimal(psacSysId));
//
//					mProd = opt.get();
//
//				}
//
//				if (ValidationUtil.isNull(psacCode)) {
//					errors.add(" Condition Code is required");
//				}
//
//				if (ValidationUtil.isValidLength(psacCode, 12)) {
//					errors.add("Condition Code Maximum length should be 12");
//				}
//
//				if (ValidationUtil.isValidLength(psacCvrCode, 12)) {
//					errors.add("Cover Code Maximum length should be 12");
//				}
//
//				if (ValidationUtil.isValidLength(psacLvl, 1)) {
//					errors.add("Level Maximum length should be 1");
//				}
//
//				if (ValidationUtil.isValidLength(psacType, 12)) {
//					errors.add("Contiton Type Maximum length should be 12");
//				}
//
//				if (ValidationUtil.isValidLength(psacDesc, 240)) {
//					errors.add("Description Maximum length should be 240");
//				}
//
//				if (ValidationUtil.isValidLength(psacDescBl, 240)) {
//					errors.add("Desc Bl Maximum length should be 240");
//				}
//
//				if (ValidationUtil.isValidLength(psacShortDesc, 60)) {
//					errors.add("Short Desc Maximum length should be 60");
//				}
//
//				if (ValidationUtil.isValidLength(psacShortDescBl, 60)) {
//					errors.add("Short Desc Bl Type Maximum length should be 60");
//				}
//
//				if (ValidationUtil.isValidLength(psacLongDesc, 4000)) {
//					errors.add("Long Desc Maximum length should be 4000");
//				}
//
//				if (ValidationUtil.isValidLength(psacLongDescBl, 4000)) {
//					errors.add("LongDescBl Maximum length should be 4000");
//				}
//
//				if (ValidationUtil.isValidYesOrNo(psacDfltYn)) {
//					errors.add("Please enter the default value 0 or 1");
//				}
//				if (ValidationUtil.isNull(psacLvl)) {
//					errors.add("Please enter the Level S or C");
//				}
//
//				if (ValidationUtil.isCheckChar(psacLvl)) {
//					errors.add("Please enter the Level S or C");
//				}
//
//				if (psacLvl.charAt(0) == 'S') {
//					if (!ValidationUtil.isNull(psacCvrCode)) {
//						errors.add("Please remove the Cover Code");
//					}
//				}
//
//				if (psacLvl.charAt(0) == 'C') {
//					if (ValidationUtil.isNull(psacCvrCode)) {
//						errors.add("Please enter the cover code");
//					}
//				}
//
//				if (ValidationUtil.isNull(ValidationUtil.covertDate(psacEffFmDt))) {
//					errors.add("Effective from date is required");
//				}
//
//				if (ValidationUtil.isNull(ValidationUtil.covertDate(psacEffToDt))) {
//					errors.add("Effective To date is required");
//				}
//
//				if (ValidationUtil.isGreaterThan(ValidationUtil.covertDate(psacEffFmDt),
//						ValidationUtil.covertDate(psacEffToDt))) {
//					errors.add("From Date is Greater than To Date");
//				}
//
////				obj.setPsacProdCode(prodCode);
////				obj.setPsacCompCode(compCode);
////				obj.setPsacSchCode(schCode);
////				obj.setPsacCode(psacCode);
////				obj.setPsacCvrCode(psacCvrCode);
////				obj.setPsacLvl(psacLvl);
////				obj.setPsacType(psacType);
////				obj.setPsacDfltYn(psacDfltYn);
////				obj.setPsacDesc(psacDesc);
////				obj.setPsacDescBl(psacDescBl);
////				obj.setPsacShortDesc(psacShortDesc);
////				obj.setPsacShortDescBl(psacShortDescBl);
////				obj.setPsacLongDesc(psacLongDesc);
////				obj.setPsacLongDescBl(psacLongDescBl);
////				obj.setPsacEffFmDt(ValidationUtil.covertDate(psacEffFmDt));
////				obj.setPsacEffToDt(ValidationUtil.covertDate(psacEffToDt));
////				obj.setPsacSrNo(psacSrNo != "" ? ValidationUtil.convertBigDecimal(psacSrNo) );
////				obj.setPascConvType(pascConvType);
//
//				if (mProd == null) {
//					mProd = MProdSchApplCond.builder().psacProdCode(prodCode).psacCompCode(compCode)
//							.psacSchCode(schCode).psacCode(psacCode).psacCvrCode(psacCvrCode).psacLvl(psacLvl)
//							.psacDfltYn(psacDfltYn).psacDesc(psacDesc).psacDescBl(psacDescBl).psacType(psacType)
//							.psacShortDesc(psacShortDesc).psacShortDescBl(psacShortDescBl).psacLongDesc(psacLongDesc)
//							.psacLongDescBl(psacLongDescBl).psacEffFmDt(ValidationUtil.covertDate(psacEffFmDt))
//							.psacEffToDt(ValidationUtil.covertDate(psacEffToDt))
//							.psacSrNo(psacSrNo != "" ? ValidationUtil.convertBigDecimal(psacSrNo) : null)
//							.pascConvType(pascConvType).build();
//
//				} else {
//
//					mProd.setPsacSysId(ValidationUtil.convertBigDecimal(psacSysId));
//					mProd.setPsacProdCode(prodCode);
//					mProd.setPsacCompCode(compCode);
//					mProd.setPsacSchCode(schCode);
//					mProd.setPsacCode(psacCode);
//					mProd.setPsacCvrCode(psacCvrCode);
//					mProd.setPsacLvl(psacLvl);
//					mProd.setPsacType(psacType);
//					mProd.setPsacDfltYn(psacDfltYn);
//					mProd.setPsacDesc(psacDesc);
//					mProd.setPsacDescBl(psacDescBl);
//					mProd.setPsacShortDesc(psacShortDesc);
//					mProd.setPsacShortDescBl(psacShortDescBl);
//					mProd.setPsacLongDesc(psacLongDesc);
//					mProd.setPsacLongDescBl(psacLongDescBl);
//					mProd.setPsacEffFmDt(ValidationUtil.covertDate(psacEffFmDt));
//					mProd.setPsacEffToDt(ValidationUtil.covertDate(psacEffToDt));
//					mProd.setPsacSrNo(psacSrNo != "" ? ValidationUtil.convertBigDecimal(psacSrNo) : null);
//					mProd.setPascConvType(pascConvType);
//
//				}
//
//				if (errors.size() > 0) {
//
//					String errorMessage = errors.stream().map(a -> String.valueOf(a)).collect(Collectors.joining(", "));
//					mProd.setRemarks(errorMessage);
//					list.add(mProd);
//					errorRecords++;
//
//				} else {
//
//					entityService.saveorupdate(mProd);
//					uploadRecords++;
//				}
//
//				value.setConditionsList(list);
//				value.setErrorRecords(errorRecords);
//				value.setTotalRecords(totalRecords);
//				value.setUploadRecords(uploadRecords);
//
//			}
//		} catch (IOException | ParseException e) {
//
//			e.printStackTrace();
//
//		}
//
//		return value;
//	}
//
//	public MPolwordingsExcelDto uploadExcelPolwordings(MultipartFile file, String prodCode) {
//
//		List<String> errors = null;
//
//		int totalRecords = 0;
//		int uploadRecords = 0;
//		int errorRecords = 0;
//
//		List<MPolWordings> list = new ArrayList<MPolWordings>();
//
//		MPolwordingsExcelDto value = new MPolwordingsExcelDto();
//
//		try (XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())) {
//			XSSFSheet worksheet = workbook.getSheetAt(0);
//
//			totalRecords = worksheet.getPhysicalNumberOfRows() - 1;
//			DataFormatter formatter = new DataFormatter();
//
//			for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
//
//				MPolWordings mProd = null;
//
//				XSSFRow row = worksheet.getRow(i);
//
//				String pwSysId = formatter.formatCellValue(row.getCell(0));
////				String pwProductCode = formatter.formatCellValue(row.getCell(1));
//				String pwWordingType = formatter.formatCellValue(row.getCell(2));
//				String pwPageName = formatter.formatCellValue(row.getCell(3));
//				String pwPageNo = formatter.formatCellValue(row.getCell(4));
//				String pwPageOrder = formatter.formatCellValue(row.getCell(5));
//				String pwPageLineNo = formatter.formatCellValue(row.getCell(6));
//				String pwDisplayText1 = formatter.formatCellValue(row.getCell(7));
//				String pwDisplayText2 = formatter.formatCellValue(row.getCell(8));
//				String pwDisplayText3 = formatter.formatCellValue(row.getCell(9));
//				String pwAllignment = formatter.formatCellValue(row.getCell(10));
//				String pwFontSize = formatter.formatCellValue(row.getCell(11));
//				String pwTextFormat = formatter.formatCellValue(row.getCell(12));
//				String pwLvl = formatter.formatCellValue(row.getCell(13));
//				String pwCoverCode = formatter.formatCellValue(row.getCell(14));
//				String pwDynamicColumn1 = formatter.formatCellValue(row.getCell(15));
//				String pwDynamicColumn2 = formatter.formatCellValue(row.getCell(16));
//				String pwDynamicColumn3 = formatter.formatCellValue(row.getCell(17));
//
//				errors = new ArrayList<>();
//
//				if (ValidationUtil.isNull(pwSysId)) {
//
//					Optional<MPolWordings> optional = mPolWordingsService
//							.findByPwProductCodeAndPwWordingTypeAndPwCoverCode(prodCode, pwWordingType, pwCoverCode);
//					if (optional.isPresent()) {
//						errors.add("Already Exist");
//					}
//
//				} else {
//					Optional<MPolWordings> opt = mPolWordingsService
//							.findById(ValidationUtil.convertBigDecimal(pwSysId));
//
//					mProd = opt.get();
//				}
//
//				if (ValidationUtil.isValidLength(pwWordingType, 50)) {
//					errors.add("PwWordingType length should be 50");
//				}
//
//				if (ValidationUtil.isValidLength(pwPageName, 50)) {
//					errors.add("PwPageName length should be 50");
//				}
//
//				if (ValidationUtil.isValidLength(pwPageOrder, 10)) {
//					errors.add("PwPageOrder length should be 10");
//				}
//
//				if (ValidationUtil.isValidLength(ValidationUtil.convertBigDecimal(pwPageLineNo), 9999)) {
//					errors.add("PwPageLineNo length should be 9999");
//				}
//
//				if (ValidationUtil.isValidLength(pwDisplayText1, 4000)) {
//					errors.add("PwDisplayText1 Max Length Should Be 4000");
//
//				}
//
//				if (ValidationUtil.isValidLength(pwDisplayText2, 4000)) {
//					errors.add("PwDisplayText2 Max Length Should Be 4000");
//
//				}
//
//				if (ValidationUtil.isValidLength(pwDisplayText3, 4000)) {
//					errors.add("PwDisplayText3 Max Length Should Be 4000");
//
//				}
//
//				if (ValidationUtil.isValidLength(pwAllignment, 1)) {
//					errors.add("Allignment Max Length Should be 1");
//				}
//
//				if (ValidationUtil.isValidLength(pwTextFormat, 1)) {
//					errors.add("PwTextformat Max Length Should be 1");
//				}
//
//				if (ValidationUtil.isValidLength(pwFontSize, 10)) {
//					errors.add("PwFontsize Max Length Should be 10");
//				}
//
//				if (ValidationUtil.isValidLength(pwLvl, 1)) {
//					errors.add("Pwlevel Max Length Should be 1");
//				}
//
//				if (ValidationUtil.isValidLength(pwCoverCode, 240)) {
//					errors.add("PwCoverCode Max Length Should be 240");
//				}
//				if (ValidationUtil.isValidLength(pwDynamicColumn1, 2000)) {
//					errors.add("PwDynamicColumn1 Max Length Should Be 2000");
//
//				}
//
//				if (ValidationUtil.isValidLength(pwDynamicColumn2, 2000)) {
//					errors.add("PwDynamicColumn2 Max Length Should Be 2000");
//				}
//
//				if (ValidationUtil.isValidLength(pwDynamicColumn3, 2000)) {
//					errors.add("PwDynamicColumn3 Max Length Should Be 2000");
//				}
//				if (ValidationUtil.isNull(pwLvl)) {
//					errors.add("Please enter the Level S or C");
//				} else if (ValidationUtil.isCheckChar(pwLvl)) {
//					errors.add("Please enter the Level S or C");
//				}
//
//				if (!ValidationUtil.isNull(pwLvl)) {
//					if (pwLvl.charAt(0) == 'S') {
//						if (!ValidationUtil.isNullCoverCode(pwCoverCode)) {
//							errors.add("Please remove the Cover Code");
//						} else if (pwLvl.charAt(0) == 'C') {
//							if (ValidationUtil.isNullCoverCode(pwCoverCode)) {
//								errors.add("Please enter the cover code");
//							}
//						}
//					}
//				}
//
//				if (mProd == null) {
//					mProd = MPolWordings.builder().pwProductCode(prodCode).pwWordingType(pwWordingType)
//							.pwCoverCode(pwCoverCode).pwPageName(pwPageName)
//							.pwPageno(ValidationUtil.convertBigDecimal(pwPageNo)).pwLvl(pwLvl)
//							.pwPageLineNo(ValidationUtil.convertBigDecimal(pwPageLineNo)).pwPageOrder(pwPageOrder)
//							.pwDisplayText1(pwDisplayText1).pwAllignment(pwAllignment).pwFontsize(pwFontSize)
//							.pwTextformat(pwTextFormat).pwDisplayText2(pwDisplayText2).pwDisplayText3(pwDisplayText3)
//							.pwDynamicColumn1(pwDynamicColumn1).pwDynamicColumn2(pwDynamicColumn2)
//							.pwDynamicColumn3(pwDynamicColumn3).build();
//
//				} else {
//
//					mProd.setPwSysId(ValidationUtil.convertBigDecimal(pwSysId));
//					mProd.setPwProductCode(prodCode);
//					mProd.setPwWordingType(pwWordingType);
//					mProd.setPwCoverCode(pwCoverCode);
//					mProd.setPwPageName(pwPageName);
//					mProd.setPwPageno(ValidationUtil.convertBigDecimal(pwPageNo));
//					mProd.setPwLvl(pwLvl);
//					mProd.setPwPageLineNo(ValidationUtil.convertBigDecimal(pwPageLineNo));
//					mProd.setPwPageOrder(pwPageOrder);
//					mProd.setPwDisplayText1(pwDisplayText1);
//					mProd.setPwAllignment(pwAllignment);
//					mProd.setPwFontsize(pwFontSize);
//					mProd.setPwTextformat(pwTextFormat);
//					mProd.setPwDisplayText2(pwDisplayText2);
//					mProd.setPwDisplayText3(pwDisplayText3);
//					mProd.setPwDynamicColumn1(pwDynamicColumn1);
//					mProd.setPwDynamicColumn2(pwDynamicColumn2);
//					mProd.setPwDynamicColumn3(pwDynamicColumn3);
//
//				}
//				if (errors.size() > 0) {
//
//					String errorMessage = errors.stream().map(a -> String.valueOf(a)).collect(Collectors.joining(", "));
//					mProd.setRemarks(errorMessage);
//					list.add(mProd);
//					errorRecords++;
//
//				} else {
//
//					mPolWordingsService.saveorupdate(mProd);
//					uploadRecords++;
//
//				}
//
//				value.setPolwordingsList(list);
//				value.setErrorRecords(errorRecords);
//				value.setTotalRecords(totalRecords);
//				value.setUploadRecords(uploadRecords);
//
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//
//		}
//		return value;
//
//	}
//
//	public boolean uploadExcelConditions(MultipartFile file) {
//
//		List<String> errors = null;
//
//		try (XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())) {
//			XSSFSheet worksheet = workbook.getSheetAt(0);
//
//			DataFormatter formatter = new DataFormatter();
//
//			XSSFRow row = worksheet.getRow(0);
//
//			String psacSysId = formatter.formatCellValue(row.getCell(0));
//			String psacProdCode = formatter.formatCellValue(row.getCell(1));
//			String psacCompCode = formatter.formatCellValue(row.getCell(2));
//			String psacSchCode = formatter.formatCellValue(row.getCell(3));
//			String psacCode = formatter.formatCellValue(row.getCell(4));
//			String psacCvrCode = formatter.formatCellValue(row.getCell(5));
//			String psacLvl = formatter.formatCellValue(row.getCell(6));
//			String psacType = formatter.formatCellValue(row.getCell(7));
//			String psacDfltYn = formatter.formatCellValue(row.getCell(8));
//			String psacDesc = formatter.formatCellValue(row.getCell(9));
//			String psacDescBl = formatter.formatCellValue(row.getCell(10));
//			String psacShortDesc = formatter.formatCellValue(row.getCell(11));
//			String psacShortDescBl = formatter.formatCellValue(row.getCell(12));
//			String psacLongDesc = formatter.formatCellValue(row.getCell(13));
//			String psacLongDescBl = formatter.formatCellValue(row.getCell(14));
//			String psacEffFmDt = formatter.formatCellValue(row.getCell(15));
//			String psacEffToDt = formatter.formatCellValue(row.getCell(16));
//			String psacSrNo = formatter.formatCellValue(row.getCell(17));
//			String psacCrDt = formatter.formatCellValue(row.getCell(18));
//			String psacCrUid = formatter.formatCellValue(row.getCell(19));
//			String psacUpdDt = formatter.formatCellValue(row.getCell(20));
//			String psacUpdUid = formatter.formatCellValue(row.getCell(21));
//			String pascConvType = formatter.formatCellValue(row.getCell(22));
//
//			errors = new ArrayList<>();
//
//			if (psacSysId.equals("PSAC_SYS_ID")) {
//				errors.add("");
//			}
//			if (psacProdCode.equals("PSAC_PROD_CODE")) {
//				errors.add("");
//			}
//			if (psacCompCode.equals("PSAC_COMP_CODE")) {
//				errors.add("");
//			}
//			if (psacSchCode.equals("PSAC_SCH_CODE")) {
//				errors.add("");
//			}
//			if (psacCode.equals("PSAC_CODE")) {
//				errors.add("");
//			}
//			if (psacCvrCode.equals("PSAC_CVR_CODE")) {
//				errors.add("");
//			}
//			if (psacLvl.equals("PSAC_LVL")) {
//				errors.add("");
//			}
//			if (psacType.equals("PSAC_TYPE")) {
//				errors.add("");
//			}
//			if (psacDfltYn.equals("PSAC_DFLT_YN")) {
//				errors.add("");
//			}
//			if (psacDesc.equals("PSAC_DESC")) {
//				errors.add("");
//			}
//			if (psacDescBl.equals("PSAC_DESC_BL")) {
//				errors.add("");
//			}
//			if (psacShortDesc.equals("PSAC_SHORT_DESC")) {
//				errors.add("");
//			}
//			if (psacShortDescBl.equals("PSAC_SHORT_DESC_BL")) {
//				errors.add("");
//			}
//			if (psacLongDesc.equals("PSAC_LONG_DESC")) {
//				errors.add("");
//			}
//			if (psacLongDescBl.equals("PSAC_LONG_DESC_BL")) {
//				errors.add("");
//			}
//			if (psacEffFmDt.equals("PSAC_EFF_FM_DT")) {
//				errors.add("");
//			}
//			if (psacEffToDt.equals("PSAC_EFF_TO_DT")) {
//				errors.add("");
//			}
//			if (psacSrNo.equals("PSAC_SR_NO")) {
//				errors.add("");
//			}
//			if (psacCrDt.equals("PSAC_CR_DT")) {
//				errors.add("");
//			}
//			if (psacCrUid.equals("PSAC_CR_UID")) {
//				errors.add("");
//			}
//			if (psacUpdDt.equals("PSAC_UPD_DT")) {
//				errors.add("");
//			}
//			if (psacUpdUid.equals("PSAC_UPD_UID")) {
//				errors.add("");
//			}
//			if (pascConvType.equals("PASC_CONV_TYPE")) {
//				errors.add("");
//			}
//
//			if (errors.size() > 0) {
//
//				return true;
//
//			} else {
//
//				return false;
//
//			}
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return true;
//		}
//
//	}
//
//	public boolean uploadExcelPolwordings(MultipartFile file) {
//		List<String> errors = null;
//
//		try (XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())) {
//			XSSFSheet worksheet = workbook.getSheetAt(0);
//
//			DataFormatter formatter = new DataFormatter();
//
//			XSSFRow row = worksheet.getRow(0);
//
//			String pwSysId = formatter.formatCellValue(row.getCell(0));
//			String pwProductCode = formatter.formatCellValue(row.getCell(1));
//			String pwWordingType = formatter.formatCellValue(row.getCell(2));
//			String pwPageName = formatter.formatCellValue(row.getCell(3));
//			String pwPageNo = formatter.formatCellValue(row.getCell(4));
//			String pwPageOrder = formatter.formatCellValue(row.getCell(5));
//			String pwPageLineNo = formatter.formatCellValue(row.getCell(6));
//			String pwDisplayText1 = formatter.formatCellValue(row.getCell(7));
//			String pwDisplayText2 = formatter.formatCellValue(row.getCell(8));
//			String pwDisplayText3 = formatter.formatCellValue(row.getCell(9));
//			String pwAllignment = formatter.formatCellValue(row.getCell(10));
//			String pwFontSize = formatter.formatCellValue(row.getCell(11));
//			String pwTextFormat = formatter.formatCellValue(row.getCell(12));
//			String pwLvl = formatter.formatCellValue(row.getCell(13));
//			String pwCoverCode = formatter.formatCellValue(row.getCell(14));
//			String pwDynamicColumn1 = formatter.formatCellValue(row.getCell(15));
//			String pwDynamicColumn2 = formatter.formatCellValue(row.getCell(16));
//			String pwDynamicColumn3 = formatter.formatCellValue(row.getCell(17));
//
//			errors = new ArrayList<>();
//
//			if (pwSysId.equals("PW_SYS_ID")) {
//				errors.add("");
//			}
//			if (pwProductCode.equals("PW_PRODUCT_CODE")) {
//				errors.add("");
//			}
//			if (pwWordingType.equals("PW_WORDING_TYPE")) {
//				errors.add("");
//			}
//			if (pwPageName.equals("PW_PAGE_NAME")) {
//				errors.add("");
//			}
//			if (pwPageNo.equals("PW_PAGENO")) {
//				errors.add("");
//			}
//			if (pwPageOrder.equals("PW_PAGE_ORDER")) {
//				errors.add("");
//			}
//			if (pwPageLineNo.equals("PW_PAGE_LINE_NO")) {
//				errors.add("");
//			}
//			if (pwDisplayText1.equals("PW_DISPLAY_TEXT_1")) {
//				errors.add("");
//			}
//			if (pwDisplayText2.equals("PW_DISPLAY_TEXT_2")) {
//				errors.add("");
//			}
//			if (pwDisplayText3.equals("PW_DISPLAY_TEXT_3")) {
//				errors.add("");
//			}
//			if (pwAllignment.equals("PW_ALLIGNMENT")) {
//				errors.add("");
//			}
//			if (pwFontSize.equals("PW_FONTSIZE")) {
//				errors.add("");
//			}
//			if (pwTextFormat.equals("PW_TEXTFORMAT")) {
//				errors.add("");
//			}
//			if (pwLvl.equals("PW_LVL")) {
//				errors.add("");
//			}
//			if (pwCoverCode.equals("PW_COVER_CODE")) {
//				errors.add("");
//			}
//			if (pwDynamicColumn1.equals("PW_DYNAMIC_COLUMN_1")) {
//				errors.add("");
//			}
//			if (pwDynamicColumn2.equals("PW_DYNAMIC_COLUMN_2")) {
//				errors.add("");
//			}
//			if (pwDynamicColumn3.equals("PW_DYNAMIC_COLUMN_3")) {
//				errors.add("");
//			}
//
//			if (errors.size() > 0) {
//
//				return true;
//
//			} else {
//
//				return false;
//
//			}
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return true;
//		}
//
//	}
//
//	public byte[] downloadExcelTariffDetails(List<MTariffLifeDetails> obj) {
//
//		try {
//
//			Resource resource = new ClassPathResource("Tariff_Life_Details_Template.xlsx");
//			InputStream fileStream = resource.getInputStream();
//
//			XSSFWorkbook workbook = new XSSFWorkbook(fileStream);
//			XSSFSheet worksheet = workbook.getSheetAt(0);
//			int rowvariable = 1;
//			Cell cell = null;
//			for (MTariffLifeDetails newObj : obj) {
//				Row row = worksheet.createRow(rowvariable);
//				cell = row.createCell(0);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdId()));
//				cell = row.createCell(1);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdMthId()));
//				cell = row.createCell(2);
//				cell.setCellValue(ValidationUtil.format(newObj.getMtdEffFmDt()));
//				cell = row.createCell(3);
//				cell.setCellValue(ValidationUtil.format(newObj.getMtdEffToDt()));
//				cell = row.createCell(4);
//				cell.setCellValue(newObj.getMtdSmokeFmCode());
//				cell = row.createCell(5);
//				cell.setCellValue(newObj.getMtdSmokeToCode());
//				cell = row.createCell(6);
//				cell.setCellValue(newObj.getMtdGenderFmCode());
//				cell = row.createCell(7);
//				cell.setCellValue(newObj.getMtdGenderToCode());
//				cell = row.createCell(8);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdAgeFm()));
//				cell = row.createCell(9);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdAgeTo()));
//				cell = row.createCell(10);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdPolicytermFm()));
//				cell = row.createCell(11);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdPolicyTermTo()));
//				cell = row.createCell(12);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdNoSeatsFm()));
//				cell = row.createCell(13);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdNoSeatsTo()));
//				cell = row.createCell(14);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdSumAssuredLimitFm()));
//				cell = row.createCell(15);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdSumAssuredLimitTo()));
//				cell = row.createCell(16);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdMaturityAgeFm()));
//				cell = row.createCell(17);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdMaturityAgeTo()));
//				cell = row.createCell(18);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdHeightFm()));
//				cell = row.createCell(19);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdHeightto()));
//				cell = row.createCell(20);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdWeightFm()));
//				cell = row.createCell(21);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdWeightTo()));
//				cell = row.createCell(22);
//				cell.setCellValue(newObj.getMtdInsuredTypeFmCode());
//				cell = row.createCell(23);
//				cell.setCellValue(newObj.getMtdInsuredTypeToCode());
//				cell = row.createCell(24);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdChildAgeFm()));
//				cell = row.createCell(25);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdChildAgeTo()));
//				cell = row.createCell(26);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdAdultCntFm()));
//				cell = row.createCell(27);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdAdultCntTo()));
//				cell = row.createCell(28);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdChildCntFm()));
//				cell = row.createCell(29);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdChildCntTo()));
//				cell = row.createCell(30);
//				cell.setCellValue(newObj.getMtdOccFmCode());
//				cell = row.createCell(31);
//				cell.setCellValue(newObj.getMtdOccToCode());
//				cell = row.createCell(32);
//				cell.setCellValue(newObj.getMtdPremfqToCode());
//				cell = row.createCell(33);
//				cell.setCellValue(newObj.getMtdPremFqFmCode());
//				cell = row.createCell(34);
//				cell.setCellValue(newObj.getMtdPara01FmCode());
//				cell = row.createCell(35);
//				cell.setCellValue(newObj.getMtdPara01ToCode());
//				cell = row.createCell(36);
//				cell.setCellValue(newObj.getMtdPara02FmCode());
//				cell = row.createCell(37);
//				cell.setCellValue(newObj.getMtdPara02ToCode());
//				cell = row.createCell(38);
//				cell.setCellValue(newObj.getMtdPara03FmCode());
//				cell = row.createCell(39);
//				cell.setCellValue(newObj.getMtdPara03ToCode());
//				cell = row.createCell(40);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdPara04FmCode()));
//				cell = row.createCell(41);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdPara04ToCode()));
//				cell = row.createCell(42);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdPara05FmCode()));
//				cell = row.createCell(43);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdPara05ToCode()));
//				cell = row.createCell(44);
//				cell.setCellValue(newObj.getMtdPara06FmCode());
//				cell = row.createCell(45);
//				cell.setCellValue(newObj.getMtdPara06ToCode());
//				cell = row.createCell(46);
//				cell.setCellValue(newObj.getMtdPara07FmCode());
//				cell = row.createCell(47);
//				cell.setCellValue(newObj.getMtdPara07ToCode());
//				cell = row.createCell(48);
//				cell.setCellValue(newObj.getMtdPara08FmCode());
//				cell = row.createCell(49);
//				cell.setCellValue(newObj.getMtdPara08ToCode());
//				cell = row.createCell(50);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdPremRate()));
//				cell = row.createCell(51);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdMinPremRate()));
//				cell = row.createCell(52);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdMaxPremRate()));
//				cell = row.createCell(53);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdRiPremRate()));
//				cell = row.createCell(54);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdRiPremRatePer()));
//				cell = row.createCell(55);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdMinSiLc1()));
//				cell = row.createCell(56);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdMaxSiLc1()));
//				cell = row.createCell(57);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdMinPremLc1()));
//				cell = row.createCell(58);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdMaxPremLc1()));
//				cell = row.createCell(59);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdDfltSi()));
//				cell = row.createCell(60);
//				cell.setCellValue(newObj.getMtdDiscCode1());
//				cell = row.createCell(61);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdDisc1Value()));
//				cell = row.createCell(62);
//				cell.setCellValue(newObj.getMtdDiscCode2());
//				cell = row.createCell(63);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdDisc2Value()));
//				cell = row.createCell(64);
//				cell.setCellValue(newObj.getMtdDiscCode3());
//				cell = row.createCell(65);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdDisc3Value()));
//				cell = row.createCell(66);
//				cell.setCellValue(newObj.getMtdDiscCode4());
//				cell = row.createCell(67);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdDisc4Value()));
//				cell = row.createCell(68);
//				cell.setCellValue(newObj.getMtdDiscCode5());
//				cell = row.createCell(69);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdDisc5Value()));
//				cell = row.createCell(70);
//				cell.setCellValue(newObj.getMtdLoadCode1());
//				cell = row.createCell(71);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdLoad1Value()));
//				cell = row.createCell(72);
//				cell.setCellValue(newObj.getMtdLoadCode2());
//				cell = row.createCell(73);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdLoad2Value()));
//				cell = row.createCell(74);
//				cell.setCellValue(newObj.getMtdLoadCode3());
//				cell = row.createCell(75);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdLoad3Value()));
//				cell = row.createCell(76);
//				cell.setCellValue(newObj.getMtdDedCode1());
//				cell = row.createCell(77);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdDed1Value()));
//				cell = row.createCell(78);
//				cell.setCellValue(newObj.getMtdDedCode2());
//				cell = row.createCell(79);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdDed2Value()));
//				cell = row.createCell(80);
//				cell.setCellValue(newObj.getMtdDedCode3());
//				cell = row.createCell(81);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdDed3Value()));
//				cell = row.createCell(82);
//				cell.setCellValue(newObj.getMtdDedCode4());
//				cell = row.createCell(83);
//				cell.setCellValue(ValidationUtil.convertString(newObj.getMtdDed4Value()));
//				cell = row.createCell(84);
//				cell.setCellValue(newObj.getMtdCrUid());
//				cell = row.createCell(85);
//				cell.setCellValue(newObj.getMtdCrDt());
//				cell = row.createCell(86);
//				cell.setCellValue(newObj.getMtdUpdUid());
//				cell = row.createCell(87);
//				cell.setCellValue(newObj.getMtdUpdDt());
//
//				rowvariable++;
//
//			}
//
//			ByteArrayOutputStream bos = new ByteArrayOutputStream();
//			workbook.write(bos);
//			workbook.close();
//			byte[] barray = bos.toByteArray();
//
//			return barray;
//		}
//
//		catch (Exception e) {
//			throw new RuntimeException("fail to export data to Excel file: " + e.getMessage());
//		}
//
//	}
//	
//	public boolean uploadExcelTariffLife(MultipartFile file) {
//		List<String> errors = null;
//
//		try (XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())) {
//			XSSFSheet worksheet = workbook.getSheetAt(0);
//
//			DataFormatter formatter = new DataFormatter();
//
//			XSSFRow row = worksheet.getRow(0);
//
//			String mtdId = formatter.formatCellValue(row.getCell(0));
//			String mtdMthId = formatter.formatCellValue(row.getCell(1));
//			String mtdEffFmDt = formatter.formatCellValue(row.getCell(2));
//			String mtdEffToDt = formatter.formatCellValue(row.getCell(3));
//			String mtdSmokeFmCode = formatter.formatCellValue(row.getCell(4));
//			String mtdSmokeToCode = formatter.formatCellValue(row.getCell(5));
//			String mtdGenderFmCode = formatter.formatCellValue(row.getCell(6));
//			String mtdGenderToCode = formatter.formatCellValue(row.getCell(7));
//			String mtdAgeFm = formatter.formatCellValue(row.getCell(8));
//			String mtdAgeTo = formatter.formatCellValue(row.getCell(9));
//			String mtdPolicytermFm = formatter.formatCellValue(row.getCell(10));
//			String mtdPolicyTermTo = formatter.formatCellValue(row.getCell(11));
//			String mtdNoSeatsFm = formatter.formatCellValue(row.getCell(12));
//			String mtdNoSeatsTo = formatter.formatCellValue(row.getCell(13));
//			String mtdSumAssuredLimitFm = formatter.formatCellValue(row.getCell(14));
//			String mtdSumAssuredLimitTo = formatter.formatCellValue(row.getCell(15));
//			String mtdMaturityAgeFm = formatter.formatCellValue(row.getCell(16));
//			String mtdMaturityAgeTo = formatter.formatCellValue(row.getCell(17));
//			String  mtdHeightFm = formatter.formatCellValue(row.getCell(18));
//			String  mtdHeightto = formatter.formatCellValue(row.getCell(19));
//			String mtdWeightFm = formatter.formatCellValue(row.getCell(20));
//			String  mtdWeightTo = formatter.formatCellValue(row.getCell(21));
//			String mtdInsuredTypeFmCode= formatter.formatCellValue(row.getCell(22));
//			String mtdInsuredTypeToCode= formatter.formatCellValue(row.getCell(23));
//			String mtdChildAgeFm = formatter.formatCellValue(row.getCell(24));
//			String  mtdChildAgeTo = formatter.formatCellValue(row.getCell(25));
//			String  mtdAdultCntFm = formatter.formatCellValue(row.getCell(26));
//			String mtdAdultCntTo  = formatter.formatCellValue(row.getCell(27));
//			String mtdChildCntFm = formatter.formatCellValue(row.getCell(28));
//			String mtdChildCntTo = formatter.formatCellValue(row.getCell(29));
//			String  mtdOccFmCode = formatter.formatCellValue(row.getCell(30));
//			String mtdOccToCode  = formatter.formatCellValue(row.getCell(31));
//			String mtdPremfqToCode = formatter.formatCellValue(row.getCell(32));
//			String  mtdPremFqFmCode = formatter.formatCellValue(row.getCell(33));
//			String  mtdPara01FmCode = formatter.formatCellValue(row.getCell(34));
//			String mtdPara01ToCode = formatter.formatCellValue(row.getCell(35));
//			String  mtdPara02FmCode = formatter.formatCellValue(row.getCell(36));
//			String  mtdPara02ToCode = formatter.formatCellValue(row.getCell(37));
//			String mtdPara03FmCode = formatter.formatCellValue(row.getCell(38));
//			String  mtdPara03ToCode = formatter.formatCellValue(row.getCell(39));
//			String mtdPara04FmCode = formatter.formatCellValue(row.getCell(40));
//			String mtdPara04ToCode = formatter.formatCellValue(row.getCell(41));
//			String mtdPara05FmCode = formatter.formatCellValue(row.getCell(42));
//			String  mtdPara05ToCode = formatter.formatCellValue(row.getCell(43));
//			String mtdPara06FmCode = formatter.formatCellValue(row.getCell(44));
//			String mtdPara06ToCode = formatter.formatCellValue(row.getCell(45));
//			String  mtdPara07FmCode = formatter.formatCellValue(row.getCell(46));
//			String  mtdPara07ToCode = formatter.formatCellValue(row.getCell(47));
//			String mtdPara08FmCode = formatter.formatCellValue(row.getCell(48));
//			String mtdPara08ToCode = formatter.formatCellValue(row.getCell(49));
//			String mtdPremRate = formatter.formatCellValue(row.getCell(50));
//			String mtdMinPremRate =	formatter.formatCellValue(row.getCell(51));
//			String mtdMaxPremRate =	formatter.formatCellValue(row.getCell(52));
//			String mtdRiPremRate = formatter.formatCellValue(row.getCell(53));
//			String mtdRiPremRatePer = formatter.formatCellValue(row.getCell(54));
//			String mtdMinSiLc1 = formatter.formatCellValue(row.getCell(55));
//			String mtdMaxSiLc1 = formatter.formatCellValue(row.getCell(56));
//			String mtdMinPremLc1 = formatter.formatCellValue(row.getCell(57));
//			String mtdMaxPremLc1 = formatter.formatCellValue(row.getCell(58));
//			String mtdDfltSi =	formatter.formatCellValue(row.getCell(59));
//			String mtdDiscCode1 = formatter.formatCellValue(row.getCell(60));
//			String mtdDisc1Value = formatter.formatCellValue(row.getCell(61));
//			String mtdDiscCode2 = formatter.formatCellValue(row.getCell(62));
//			String mtdDisc2Value = formatter.formatCellValue(row.getCell(63));
//			String mtdDiscCode3 = formatter.formatCellValue(row.getCell(64));
//			String mtdDisc3Value = formatter.formatCellValue(row.getCell(65));
//			String mtdDiscCode4 = formatter.formatCellValue(row.getCell(66));
//			String mtdDisc4Value = formatter.formatCellValue(row.getCell(67));
//			String mtdDiscCode5 = formatter.formatCellValue(row.getCell(68));
//			String mtdDisc5Value = formatter.formatCellValue(row.getCell(69));
//			String mtdLoadCode1 = formatter.formatCellValue(row.getCell(70));
//			String mtdLoad1Value = formatter.formatCellValue(row.getCell(71));
//			String mtdLoadCode2 = formatter.formatCellValue(row.getCell(72));
//			String mtdLoad2Value = formatter.formatCellValue(row.getCell(73));
//			String mtdLoadCode3 = formatter.formatCellValue(row.getCell(74));
//			String mtdLoad3Value = formatter.formatCellValue(row.getCell(75));
//			String mtdDedCode1 = formatter.formatCellValue(row.getCell(76));
//			String mtdDed1Value = formatter.formatCellValue(row.getCell(77));
//			String mtdDedCode2 = formatter.formatCellValue(row.getCell(78));
//			String mtdDed2Value= formatter.formatCellValue(row.getCell(79));
//			String mtdDedCode3 = formatter.formatCellValue(row.getCell(80));
//			String mtdDed3Value = formatter.formatCellValue(row.getCell(81));
//			String mtdDedCode4 = formatter.formatCellValue(row.getCell(82));
//			String mtdDed4Value = formatter.formatCellValue(row.getCell(83));
//			String mtdCrUid = formatter.formatCellValue(row.getCell(84));
//			String mtdCrDt = formatter.formatCellValue(row.getCell(85));
//			String mtdUpdUid = formatter.formatCellValue(row.getCell(86));
//			String mtdUpdDt = formatter.formatCellValue(row.getCell(87));
//
//			errors = new ArrayList<>();
//			
//			if(mtdId.equals("MTD_ID")) {
//				errors.add("");
//			}
//			if(mtdMthId.equals("MTD_MTH_ID")) {					
//				errors.add("");	
//			}		
//			if(mtdEffFmDt.equals("MTD_EFF_FM_DT")) {					
//				errors.add("");	
//			}		
//			if(mtdEffToDt.equals("MTD_EFF_TO_DT")) {					
//				errors.add("");	
//			}		
//			if(mtdSmokeFmCode.equals("MTD_SMOKE_FM_CODE")) {					
//				errors.add("");	
//			}		
//			if(mtdSmokeToCode.equals("MTD_SMOKE_TO_CODE")) {					
//				errors.add("");	
//			}		
//			if(mtdGenderFmCode.equals("MTD_GENDER_FM_CODE")) {					
//				errors.add("");	
//			}		
//			if(mtdGenderToCode.equals("MTD_GENDER_TO_CODE")) {					
//				errors.add("");	
//			}		
//			if(mtdAgeFm.equals("MTD_AGE_FM")) {					
//				errors.add("");	
//			}		
//			if(mtdAgeTo.equals("MTD_AGE_TO")) {					
//				errors.add("");	
//			}		
//			if(mtdPolicytermFm.equals("MTD_POLICY_TERM_FM")) {					
//				errors.add("");	
//			}		
//			if(mtdPolicyTermTo.equals("MTD_POLICY_TERM_TO")) {					
//				errors.add("");	
//			}		
//			if(mtdNoSeatsFm.equals("MTD_NO_SEATS_FM")) {					
//				errors.add("");	
//			}		
//			if(mtdNoSeatsTo.equals("MTD_NO_SEATS_TO")) {					
//				errors.add("");	
//			}		
//			if(mtdSumAssuredLimitFm.equals("MTD_SUM_ASSURED_LIMIT_FM")) {					
//				errors.add("");	
//			}		
//			if(mtdSumAssuredLimitTo.equals("MTD_SUM_ASSURED_LIMIT_TO")) {					
//				errors.add("");	
//			}		
//			if(mtdMaturityAgeFm.equals("MTD_MATURITY_AGE_FM")) {					
//				errors.add("");	
//			}		
//			if(mtdMaturityAgeTo.equals("MTD_MATURITY_AGE_TO")) {					
//				errors.add("");	
//			}		
//			if(mtdHeightFm.equals("MTD_HEIGHT_FM")) {					
//				errors.add("");	
//			}		
//			if(mtdHeightto.equals("MTD_HEIGHT_TO")) {					
//				errors.add("");	
//			}		
//			if(mtdWeightFm.equals("MTD_WEIGHT_FM")) {					
//				errors.add("");	
//			}		
//			if(mtdWeightTo.equals("MTD_WEIGHT_TO")) {					
//				errors.add("");	
//			}		
//			if(mtdInsuredTypeFmCode.equals("MTD_INSURED_TYPE_FM_CODE")) {					
//				errors.add("");	
//			}		
//			if(mtdInsuredTypeToCode.equals("MTD_INSURED_TYPE_TO_CODE")) {					
//				errors.add("");	
//			}		
//			if(mtdChildAgeFm.equals("MTD_CHILD_AGE_FM")) {					
//				errors.add("");	
//			}		
//			if(mtdChildAgeTo.equals("MTD_CHILD_AGE_TO")) {					
//				errors.add("");	
//			}		
//			if(mtdAdultCntFm.equals("MTD_ADULT_CNT_FM")) {					
//				errors.add("");	
//			}		
//			if(mtdAdultCntTo.equals("MTD_ADULT_CNT_TO")) {					
//				errors.add("");	
//			}		
//			if(mtdChildCntFm.equals("MTD_CHILD_CNT_FM")) {					
//				errors.add("");	
//			}		
//			if(mtdChildCntTo.equals("MTD_CHILD_CNT_TO")) {					
//				errors.add("");	
//			}		
//			if(mtdOccFmCode.equals("MTD_OCC_FM_CODE")) {					
//				errors.add("");	
//			}		
//			if(mtdOccToCode.equals("MTD_OCC_TO_CODE")) {					
//				errors.add("");	
//			}		
//			if(mtdPremfqToCode.equals("MTD_PREM_FQ_TO_CODE")) {					
//				errors.add("");	
//			}		
//			if(mtdPremFqFmCode.equals("MTD_PREM_FQ_FM_CODE")) {					
//				errors.add("");	
//			}		
//			if(mtdPara01FmCode.equals("MTD_PARA_01_FM_CODE")) {					
//				errors.add("");	
//			}		
//			if(mtdPara01ToCode.equals("MTD_PARA_01_TO_CODE")) {					
//				errors.add("");	
//			}		
//			if(mtdPara02FmCode.equals("MTD_PARA_02_FM_CODE")) {					
//				errors.add("");	
//			}		
//			if(mtdPara02ToCode.equals("MTD_PARA_02_TO_CODE")) {					
//				errors.add("");	
//			}		
//			if(mtdPara03FmCode.equals("MTD_PARA_03_FM_CODE")) {					
//				errors.add("");	
//			}		
//			if(mtdPara03ToCode.equals("MTD_PARA_03_TO_CODE")) {					
//				errors.add("");	
//			}		
//			if(mtdPara04FmCode.equals("MTD_PARA_04_FM_CODE")) {					
//				errors.add("");	
//			}		
//			if(mtdPara04ToCode.equals("MTD_PARA_04_TO_CODE")) {					
//				errors.add("");	
//			}		
//			if(mtdPara05FmCode.equals("MTD_PARA_05_FM_CODE")) {					
//				errors.add("");	
//			}		
//			if(mtdPara05ToCode.equals("MTD_PARA_05_TO_CODE")) {					
//				errors.add("");	
//			}		
//			if(mtdPara06FmCode.equals("MTD_PARA_06_FM_CODE")) {					
//				errors.add("");	
//			}		
//			if(mtdPara06ToCode.equals("MTD_PARA_06_TO_CODE")) {					
//				errors.add("");	
//			}		
//			if(mtdPara07FmCode.equals("MTD_PARA_07_FM_CODE")) {					
//				errors.add("");	
//			}		
//			if(mtdPara07ToCode.equals("MTD_PARA_07_TO_CODE")) {					
//				errors.add("");	
//			}		
//			if(mtdPara08FmCode.equals("MTD_PARA_08_FM_CODE")) {					
//				errors.add("");	
//			}		
//			if(mtdPara08ToCode.equals("MTD_PARA_08_TO_CODE")) {					
//				errors.add("");	
//			}		
//			if(mtdPremRate.equals("MTD_PREM_RATE")) {					
//				errors.add("");	
//			}		
//			if(mtdMinPremRate.equals("MTD_MIN_PREM_RATE")) {					
//				errors.add("");	
//			}		
//			if(mtdMaxPremRate.equals("MTD_MAX_PREM_RATE")) {					
//				errors.add("");	
//			}		
//			if(mtdRiPremRate.equals("MTD_RI_PREM_RATE")) {					
//				errors.add("");	
//			}		
//			if(mtdRiPremRatePer.equals("MTD_RI_PREM_RATE_PER")) {					
//				errors.add("");	
//			}		
//			if(mtdMinSiLc1.equals("MTD_MIN_SI_LC_1")) {					
//				errors.add("");	
//			}		
//			if(mtdMaxSiLc1.equals("MTD_MAX_SI_LC_1")) {					
//				errors.add("");	
//			}		
//			if(mtdMinPremLc1.equals("MTD_MIN_PREM_LC_1")) {					
//				errors.add("");	
//			}		
//			if(mtdMaxPremLc1.equals("MTD_MAX_PREM_LC_1")) {					
//						errors.add("");	
//					}		
//			if(mtdDfltSi.equals("MTD_DFLT_SI")) {					
//						errors.add("");	
//					}		
//			if(mtdDiscCode1.equals("MTD_DISC_CODE_1")) {					
//						errors.add("");	
//					}		
//			if(mtdDisc1Value.equals("MTD_DISC_1_VALUE")) {					
//						errors.add("");	
//					}		
//			if(mtdDiscCode2.equals("MTD_DISC_CODE_2")) {					
//						errors.add("");	
//					}		
//			if(mtdDisc2Value.equals("MTD_DISC_2_VALUE")) {					
//						errors.add("");	
//					}		
//			if(mtdDiscCode3.equals("MTD_DISC_CODE_3")) {					
//						errors.add("");	
//					}		
//			if(mtdDisc3Value.equals("MTD_DISC_3_VALUE")) {					
//						errors.add("");	
//					}		
//			if(mtdDiscCode4.equals("MTD_DISC_CODE_4")) {					
//						errors.add("");	
//					}		
//			if(mtdDisc4Value.equals("MTD_DISC_4_VALUE")) {					
//						errors.add("");	
//					}
//			if(mtdDiscCode5.equals("MTD_DISC_CODE_5")) {					
//				errors.add("");	
//					}		
//			if(mtdDisc5Value.equals("MTD_DISC_5_VALUE")) {					
//				errors.add("");	
//			}
//
//			if(mtdLoadCode1.equals("MTD_LOAD_CODE_1")) {					
//				errors.add("");	
//			}
//			if(mtdLoad1Value.equals("MTD_LOAD_1_VALUE")) {					
//				errors.add("");	
//			}
//			if(mtdLoadCode2.equals("MTD_LOAD_CODE_2")) {					
//				errors.add("");	
//			}
//			if(mtdLoad2Value.equals("MTD_LOAD_2_VALUE")) {					
//				errors.add("");	
//			}
//			if(mtdLoadCode3.equals("MTD_LOAD_CODE_3")) {					
//				errors.add("");	
//			}
//			if(mtdLoad3Value.equals("MTD_LOAD_3_VALUE")) {					
//				errors.add("");	
//			}
//			if(mtdDedCode1.equals("MTD_DED_CODE_1")) {					
//				errors.add("");	
//			}
//			if(mtdDed1Value.equals("MTD_DED_1_VALUE")) {					
//				errors.add("");	
//			}
//			if(mtdDedCode2.equals("MTD_DED_CODE_2")) {					
//				errors.add("");	
//			}
//			if(mtdDed2Value.equals("MTD_DED_2_VALUE")) {					
//				errors.add("");	
//			}
//			if(mtdDedCode3.equals("MTD_DED_CODE_3")) {					
//				errors.add("");	
//			}
//			if(mtdDed3Value.equals("MTD_DED_3_VALUE")) {					
//				errors.add("");	
//			}
//			if(mtdDedCode4.equals("MTD_DED_CODE_4")) {					
//				errors.add("");	
//			}
//			if(mtdDed4Value.equals("MTD_DED_4_VALUE")) {					
//				errors.add("");	
//			}
//			if(mtdCrUid.equals("MTD_CR_UID")) {					
//				errors.add("");	
//			}
//			if(mtdCrDt.equals("MTD_CR_DT")) {					
//				errors.add("");	
//			}
//			if(mtdUpdUid.equals("MTD_UPD_UID")) {					
//				errors.add("");	
//			}
//			if(mtdUpdDt.equals("MTD_UPD_DT")) {					
//				errors.add("");	
//			}
//	
//
//			if (errors.size() > 0) {
//
//				return true;
//
//			} else {
//
//				return false;
//
//			}
//
//		} catch (IOException e) {
//			e.printStackTrace();
//			return true;
//		}
//		
//	}
//
//	
//	
//	public MTariffLifeDetailsExcelDto uploadExcelTariffLife(MultipartFile file, String mthId) {
//		
//		List<String> errors = null;
//
//		int totalRecords = 0;
//		int uploadRecords = 0;
//		int errorRecords = 0;
//
//		MTariffLifeDetailsExcelDto value = new MTariffLifeDetailsExcelDto();
//		
//		List<MTariffLifeDetails> list = new ArrayList<MTariffLifeDetails>();
//
//		try (XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())) {
//			XSSFSheet worksheet = workbook.getSheetAt(0);
//
//			DataFormatter formatter = new DataFormatter();
//			
//			totalRecords = worksheet.getPhysicalNumberOfRows() - 1;
//			
//
//			for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
//
//				MTariffLifeDetails obj = null;
//
//				XSSFRow row = worksheet.getRow(i);
//
//				String mtdId = formatter.formatCellValue(row.getCell(0));
//				//String mtdMthId = formatter.formatCellValue(row.getCell(1));
//				String mtdEffFmDt = formatter.formatCellValue(row.getCell(2));
//				String mtdEffToDt = formatter.formatCellValue(row.getCell(3));
//				String mtdSmokeFmCode = formatter.formatCellValue(row.getCell(4));
//				String mtdSmokeToCode = formatter.formatCellValue(row.getCell(5));
//				String mtdGenderFmCode = formatter.formatCellValue(row.getCell(6));
//				String mtdGenderToCode = formatter.formatCellValue(row.getCell(7));
//				String mtdAgeFm = formatter.formatCellValue(row.getCell(8));
//				String mtdAgeTo = formatter.formatCellValue(row.getCell(9));
//				String mtdPolicytermFm = formatter.formatCellValue(row.getCell(10));
//				String mtdPolicyTermTo = formatter.formatCellValue(row.getCell(11));
//				String mtdNoSeatsFm = formatter.formatCellValue(row.getCell(12));
//				String mtdNoSeatsTo = formatter.formatCellValue(row.getCell(13));
//				String mtdSumAssuredLimitFm = formatter.formatCellValue(row.getCell(14));
//				String mtdSumAssuredLimitTo = formatter.formatCellValue(row.getCell(15));
//				String mtdMaturityAgeFm = formatter.formatCellValue(row.getCell(16));
//				String mtdMaturityAgeTo = formatter.formatCellValue(row.getCell(17));
//				String  mtdHeightFm = formatter.formatCellValue(row.getCell(18));
//				String  mtdHeightto = formatter.formatCellValue(row.getCell(19));
//				String mtdWeightFm = formatter.formatCellValue(row.getCell(20));
//				String  mtdWeightTo = formatter.formatCellValue(row.getCell(21));
//				String mtdInsuredTypeFmCode= formatter.formatCellValue(row.getCell(22));
//				String mtdInsuredTypeToCode= formatter.formatCellValue(row.getCell(23));
//				String mtdChildAgeFm = formatter.formatCellValue(row.getCell(24));
//				String  mtdChildAgeTo = formatter.formatCellValue(row.getCell(25));
//				String  mtdAdultCntFm = formatter.formatCellValue(row.getCell(26));
//				String mtdAdultCntTo  = formatter.formatCellValue(row.getCell(27));
//				String mtdChildCntFm = formatter.formatCellValue(row.getCell(28));
//				String mtdChildCntTo = formatter.formatCellValue(row.getCell(29));
//				String  mtdOccFmCode = formatter.formatCellValue(row.getCell(30));
//				String mtdOccToCode  = formatter.formatCellValue(row.getCell(31));
//				String mtdPremfqToCode = formatter.formatCellValue(row.getCell(32));
//				String  mtdPremFqFmCode = formatter.formatCellValue(row.getCell(33));
//				String  mtdPara01FmCode = formatter.formatCellValue(row.getCell(34));
//				String mtdPara01ToCode = formatter.formatCellValue(row.getCell(35));
//				String  mtdPara02FmCode = formatter.formatCellValue(row.getCell(36));
//				String  mtdPara02ToCode = formatter.formatCellValue(row.getCell(37));
//				String mtdPara03FmCode = formatter.formatCellValue(row.getCell(38));
//				String  mtdPara03ToCode = formatter.formatCellValue(row.getCell(39));
//				String mtdPara04FmCode = formatter.formatCellValue(row.getCell(40));
//				String mtdPara04ToCode = formatter.formatCellValue(row.getCell(41));
//				String mtdPara05FmCode = formatter.formatCellValue(row.getCell(42));
//				String  mtdPara05ToCode = formatter.formatCellValue(row.getCell(43));
//				String mtdPara06FmCode = formatter.formatCellValue(row.getCell(44));
//				String mtdPara06ToCode = formatter.formatCellValue(row.getCell(45));
//				String  mtdPara07FmCode = formatter.formatCellValue(row.getCell(46));
//				String  mtdPara07ToCode = formatter.formatCellValue(row.getCell(47));
//				String mtdPara08FmCode = formatter.formatCellValue(row.getCell(48));
//				String mtdPara08ToCode = formatter.formatCellValue(row.getCell(59));
//				String mtdPremRate = formatter.formatCellValue(row.getCell(50));
//				String mtdMinPremRate =	formatter.formatCellValue(row.getCell(51));
//				String mtdMaxPremRate =	formatter.formatCellValue(row.getCell(52));
//				String mtdRiPremRate = formatter.formatCellValue(row.getCell(53));
//				String mtdRiPremRatePer = formatter.formatCellValue(row.getCell(54));
//				String mtdMinSiLc1 = formatter.formatCellValue(row.getCell(55));
//				String mtdMaxSiLc1 = formatter.formatCellValue(row.getCell(56));
//				String mtdMinPremLc1 = formatter.formatCellValue(row.getCell(57));
//				String mtdMaxPremLc1 = formatter.formatCellValue(row.getCell(58));
//				String mtdDfltSi =	formatter.formatCellValue(row.getCell(59));
//				String mtdDiscCode1 = formatter.formatCellValue(row.getCell(60));
//				String mtdDisc1Value = formatter.formatCellValue(row.getCell(61));
//				String mtdDiscCode2 = formatter.formatCellValue(row.getCell(62));
//				String mtdDisc2Value = formatter.formatCellValue(row.getCell(63));
//				String mtdDiscCode3 = formatter.formatCellValue(row.getCell(64));
//				String mtdDisc3Value = formatter.formatCellValue(row.getCell(65));
//				String mtdDiscCode4 = formatter.formatCellValue(row.getCell(66));
//				String mtdDisc4Value = formatter.formatCellValue(row.getCell(67));
//				String mtdDiscCode5 = formatter.formatCellValue(row.getCell(68));
//				String mtdDisc5Value = formatter.formatCellValue(row.getCell(69));
//				String mtdLoadCode1 = formatter.formatCellValue(row.getCell(70));
//				String mtdLoad1Value = formatter.formatCellValue(row.getCell(71));
//				String mtdLoadCode2 = formatter.formatCellValue(row.getCell(72));
//				String mtdLoad2Value = formatter.formatCellValue(row.getCell(73));
//				String mtdLoadCode3 = formatter.formatCellValue(row.getCell(74));
//				String mtdLoad3Value = formatter.formatCellValue(row.getCell(75));
//				String mtdDedCode1 = formatter.formatCellValue(row.getCell(76));
//				String mtdDed1Value = formatter.formatCellValue(row.getCell(77));
//				String mtdDedCode2 = formatter.formatCellValue(row.getCell(78));
//				String mtdDed2Value= formatter.formatCellValue(row.getCell(79));
//				String mtdDedCode3 = formatter.formatCellValue(row.getCell(80));
//				String mtdDed3Value = formatter.formatCellValue(row.getCell(81));
//				String mtdDedCode4 = formatter.formatCellValue(row.getCell(82));
//				String mtdDed4Value = formatter.formatCellValue(row.getCell(83));
////				String mtdCrUid = formatter.formatCellValue(row.getCell(84));
////				String mtdCrDt = formatter.formatCellValue(row.getCell(85));
////				String mtdUpdUid = formatter.formatCellValue(row.getCell(86));
////				String mtdUpdDt = formatter.formatCellValue(row.getCell(87));
//
//
//
//				errors = new ArrayList<>();
//				
//				if (ValidationUtil.isNull(ValidationUtil.convertBigDecimal(mtdId))) {
//					Optional<MTariffLifeDetails> optional = tariffLifeService.findByMthId(ValidationUtil.convertBigDecimal(mthId));
//
//					if (optional.isPresent()) {
//						errors.add("Already Exist");
//					}
//
//				} else {
//
//					Optional<MTariffLifeDetails> opt = tariffLifeService
//							.findByMtdId(ValidationUtil.convertBigDecimal(mtdId));
//
//					obj = opt.get();
//
//				}
//				
//
////				Optional<MTariffLifeDetails> optional = tariffLifeService
////						.findByMtdId(ValidationUtil.convertBigDecimal(mtdId));
////				
////				if (optional.isPresent()) {
////					errors.add("Already Exist");
////				}
//				
//				
//				if(ValidationUtil.isNull(ValidationUtil.covertDate(mtdEffFmDt))) {
//					errors.add("Effective from date is required");
//				}
//				if(ValidationUtil.isNull(ValidationUtil.covertDate(mtdEffToDt))) {
//					errors.add("Effective To date is required");
//				}
//				if (ValidationUtil.isGreaterThan(ValidationUtil.covertDate(mtdEffFmDt),
//						ValidationUtil.covertDate(mtdEffToDt))) {
//					errors.add("From Date is Greater than To Date");
//				}
//
//				if (ValidationUtil.isValidLength(mtdSmokeFmCode, 12)) {
//					errors.add("MtdSmokeFmCode length should be 12");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdSmokeToCode, 12)) {
//					errors.add("MtdSmokeToCode should be 12");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdGenderFmCode, 12)) {
//					errors.add("MtdGenderFmCode length should be 12");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdGenderToCode, 12)) {
//					errors.add("MtdGenderToCode length should be 12");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdAgeFm, 99)) {
//					errors.add("MtdAgeFm length should be 99");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdAgeTo, 99)) {
//					errors.add("MtdAgeTo length should be 99");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdPolicytermFm, 99)) {
//					errors.add("MtdPolicytermFm length should be 99");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdPolicyTermTo, 99)) {
//					errors.add("MtdPolicyTermTo length should be 99");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdNoSeatsFm, 99)) {
//					errors.add("MtdNoSeatsFm length should be 99");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdNoSeatsTo, 99)) {
//					errors.add("MtdNoSeatsTo length should be 99");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdSumAssuredLimitFm, 99)) {
//					errors.add("MtdSumAssuredLimitFm length should be 99");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdSumAssuredLimitTo, 99)) {
//					errors.add("MtdSumAssuredLimitTo length should be 99");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdMaturityAgeFm, 99)) {
//					errors.add("MtdMaturityAgeFm length should be 99");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdInsuredTypeFmCode, 12)) {
//					errors.add("MtdInsuredTypeFmCode length should be 12");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdInsuredTypeToCode, 12)) {
//					errors.add("MtdInsuredTypeToCode length should be 12");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdChildAgeFm, 99)) {
//					errors.add("MtdChildAgeFm length should be 99");
//				} 
//				
//				if (ValidationUtil.isValidLength(mtdOccFmCode, 12)) {
//					errors.add("MtdOccFmCode length should be 12");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdOccToCode, 12)) {
//					errors.add("MtdOccToCode length should be 12");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdPremFqFmCode, 12)) {
//					errors.add("MtdPremFqFmCode length should be 12");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdPremfqToCode, 12)) {
//					errors.add("MtdPremfqToCode length should be 12");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdPara01FmCode, 12)) {
//					errors.add("MtdPara01FmCode length should be 12");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdPara01ToCode, 12)) {
//					errors.add("MtdPara01ToCode length should be 12");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdPara02FmCode, 12)) {
//					errors.add("MtdPara02FmCode length should be 12");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdPara02ToCode, 12)) {
//					errors.add("MtdPara02ToCode length should be 12");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdPara03FmCode, 12)) {
//					errors.add("MtdPara03FmCode length should be 12");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdPara03ToCode, 12)) {
//					errors.add("MtdPara03ToCode length should be 12");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdPara04FmCode, 9999)) {
//					errors.add("MtdPara04FmCode length should be 9999");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdPara04ToCode, 9999)) {
//					errors.add("MtdPara04ToCode length should be 9999");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdPara05FmCode, 99)) {
//					errors.add("MtdPara05FmCode length should be 99");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdPara05ToCode, 99)) {
//					errors.add("MtdPara05ToCode length should be 99");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdPara06FmCode, 12)) {
//					errors.add("MtdPara06FmCode length should be 12");
//				} 
//				
//				if (ValidationUtil.isValidLength(mtdPara06ToCode, 12)) {
//					errors.add("MtdPara06ToCode length should be 12");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdPara07FmCode, 12)) {
//					errors.add("MtdPara07FmCode length should be 12");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdPara07ToCode, 12)) {
//					errors.add("MtdPara07ToCode length should be 12");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdPara08FmCode, 12)) {
//					errors.add("MtdPara08FmCode length should be 12");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdDiscCode1, 12)) {
//					errors.add("MtdDiscCode1 length should be 12");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdDiscCode2, 12)) {
//					errors.add("MtdDiscCode2 length should be 12");
//				} 
//				
//				if (ValidationUtil.isValidLength(mtdDiscCode3, 12)) {
//					errors.add("MtdDiscCode3 length should be 12");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdDiscCode4, 12)) {
//					errors.add("MtdDiscCode4 length should be 12");
//				}
//				
//				if (ValidationUtil.isValidLength(mtdDiscCode5, 12)) {
//					errors.add("MtdDiscCode5 length should be 12");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdLoadCode1, 12)) {
//					errors.add("MtdLoadCode1 length should be 12");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdLoadCode2, 12)) {
//					errors.add("MtdLoadCode2 length should be 12");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdLoadCode3, 12)) {
//					errors.add("MtdLoadCode3 length should be 12");
//				} 
//				if (ValidationUtil.isValidLength(mtdDedCode1, 12)) {
//					errors.add("MtdDedCode1 length should be 12");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdDedCode2, 12)) {
//					errors.add("MtdDedCode2 length should be 12");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdDedCode3, 12)) {
//					errors.add("MtdDedCode3 length should be 12");
//				} 
//
//				if (ValidationUtil.isValidLength(mtdDedCode4, 12)) {
//					errors.add("MtdDedCode4 length should be 12");
//				} 
//				
//	
//				if (null == obj) {
//
//					obj = MTariffLifeDetails.builder().mtdMthId(ValidationUtil.convertBigDecimal(mthId))
//							.mtdEffFmDt(ValidationUtil.covertDate(mtdEffFmDt)).mtdEffToDt(ValidationUtil.covertDate(mtdEffToDt))
//							.mtdSmokeFmCode(mtdSmokeFmCode)
//							.mtdSmokeToCode(mtdSmokeToCode).mtdGenderFmCode(mtdGenderFmCode)
//							.mtdGenderToCode(mtdGenderToCode).mtdAgeFm(ValidationUtil.convertBigDecimal(mtdAgeFm))
//							.mtdAgeTo(ValidationUtil.convertBigDecimal(mtdAgeTo)).mtdPolicytermFm(ValidationUtil.convertBigDecimal(mtdPolicytermFm))
//							.mtdPolicyTermTo(ValidationUtil.convertBigDecimal(mtdPolicyTermTo)).mtdNoSeatsFm(ValidationUtil.convertBigDecimal(mtdNoSeatsFm))
//							.mtdNoSeatsTo(ValidationUtil.convertBigDecimal(mtdNoSeatsTo)).mtdSumAssuredLimitFm(ValidationUtil.convertBigDecimal(mtdSumAssuredLimitFm))
//							.mtdSumAssuredLimitTo(ValidationUtil.convertBigDecimal(mtdSumAssuredLimitTo))
//							.mtdMaturityAgeFm(ValidationUtil.convertBigDecimal(mtdMaturityAgeFm)).mtdMaturityAgeTo(ValidationUtil.convertBigDecimal(mtdMaturityAgeTo))
//							.mtdHeightFm(ValidationUtil.convertBigDecimal(mtdHeightFm)).mtdHeightto(ValidationUtil.convertBigDecimal(mtdHeightto))
//							.mtdWeightFm(ValidationUtil.convertBigDecimal(mtdWeightFm)).mtdWeightTo(ValidationUtil.convertBigDecimal(mtdWeightTo))
//							.mtdInsuredTypeFmCode(mtdInsuredTypeFmCode)
//							.mtdInsuredTypeToCode(mtdInsuredTypeToCode)
//							.mtdChildAgeFm(ValidationUtil.convertBigDecimal(mtdChildAgeFm))
//							.mtdChildAgeTo(ValidationUtil.convertBigDecimal(mtdChildAgeTo)).mtdAdultCntFm(ValidationUtil.convertBigDecimal(mtdAdultCntFm))
//							.mtdAdultCntTo(ValidationUtil.convertBigDecimal(mtdAdultCntTo)).mtdChildCntFm(ValidationUtil.convertBigDecimal(mtdChildCntFm))
//							.mtdChildCntTo(ValidationUtil.convertBigDecimal(mtdChildCntTo)).mtdOccFmCode(mtdOccFmCode)
//							.mtdOccToCode(mtdOccToCode).mtdPremfqToCode(mtdPremfqToCode)
//							.mtdPremFqFmCode(mtdPara01FmCode).mtdPara01FmCode(mtdPara01FmCode)
//							.mtdPara01ToCode(mtdPara01ToCode).mtdPara02FmCode(mtdPara02FmCode)
//							.mtdPara02ToCode(mtdPara02ToCode).mtdPara03FmCode(mtdPara03FmCode)
//							.mtdPara03ToCode(mtdPara03ToCode).mtdPara04FmCode(ValidationUtil.convertBigDecimal(mtdPara04FmCode))
//							.mtdPara04ToCode(ValidationUtil.convertBigDecimal(mtdPara04ToCode)).mtdPara05FmCode(ValidationUtil.convertBigDecimal(mtdPara05FmCode))
//							.mtdPara05ToCode(ValidationUtil.convertBigDecimal(mtdPara05ToCode)).mtdPara06FmCode(mtdPara06FmCode)
//							.mtdPara06ToCode(mtdPara06ToCode).mtdPara07FmCode(mtdPara07FmCode)
//							.mtdPara07ToCode(mtdPara07ToCode).mtdPara08FmCode(mtdPara08FmCode)
//							.mtdPara08ToCode(mtdPara08ToCode).mtdPremRate(ValidationUtil.convertBigDecimal(mtdMaxPremRate))
//							.mtdMinPremRate(ValidationUtil.convertBigDecimal(mtdMinPremRate)).mtdMaxPremRate(ValidationUtil.convertBigDecimal(mtdPremRate))
//							.mtdMinSiLc1(ValidationUtil.convertBigDecimal(mtdMinSiLc1)).mtdMaxSiLc1(ValidationUtil.convertBigDecimal(mtdMaxSiLc1))
//							.mtdMinPremLc1(ValidationUtil.convertBigDecimal(mtdMinPremLc1)).mtdMaxPremLc1(ValidationUtil.convertBigDecimal(mtdMaxPremLc1))
//							.mtdDfltSi(ValidationUtil.convertBigDecimal(mtdDfltSi)).mtdDiscCode1(mtdDiscCode1)
//							.mtdDisc1Value(ValidationUtil.convertBigDecimal(mtdDisc1Value)).mtdDiscCode2(mtdDiscCode2)
//							.mtdDisc2Value(ValidationUtil.convertBigDecimal(mtdDisc2Value)).mtdDiscCode3(mtdDiscCode3)
//							.mtdDisc3Value(ValidationUtil.convertBigDecimal(mtdDisc3Value)).mtdDiscCode4(mtdDiscCode4)
//							.mtdDisc4Value(ValidationUtil.convertBigDecimal(mtdDisc4Value)).mtdDiscCode5(mtdDiscCode5)
//							.mtdDisc5Value(ValidationUtil.convertBigDecimal(mtdDisc5Value)).mtdLoadCode1(mtdLoadCode1)
//							.mtdLoad1Value(ValidationUtil.convertBigDecimal(mtdLoad1Value)).mtdLoadCode2(mtdLoadCode2)
//							.mtdLoad2Value(ValidationUtil.convertBigDecimal(mtdLoad2Value)).mtdLoadCode3(mtdLoadCode3)
//							.mtdLoad3Value(ValidationUtil.convertBigDecimal(mtdLoad3Value)).mtdDedCode1(mtdDedCode1)
//							.mtdDed1Value(ValidationUtil.convertBigDecimal(mtdDed1Value)).mtdDedCode2(mtdDedCode2)
//							.mtdDed2Value(ValidationUtil.convertBigDecimal(mtdDed2Value)).mtdDedCode3(mtdDedCode3)
//							.mtdDed3Value(ValidationUtil.convertBigDecimal(mtdDed3Value)).mtdDedCode4(mtdDedCode4)
//							.mtdDed4Value(ValidationUtil.convertBigDecimal(mtdDed4Value)).build();
//
//				} else {
//		
//					obj.setMtdId(ValidationUtil.convertBigDecimal(mtdId));
//				obj.setMtdMthId( ValidationUtil.convertBigDecimal(mthId));
//				obj.setMtdEffFmDt(ValidationUtil.covertDate(mtdEffFmDt));
//				obj.setMtdEffToDt(ValidationUtil.covertDate(mtdEffToDt));
//				obj.setMtdSmokeFmCode(mtdSmokeFmCode);
//				obj.setMtdSmokeToCode(mtdSmokeToCode);
//				obj.setMtdGenderFmCode(mtdGenderFmCode);
//				obj.setMtdGenderToCode(mtdGenderToCode);
//				obj.setMtdAgeFm(ValidationUtil.convertBigDecimal(mtdAgeFm));
//				obj.setMtdAgeTo( ValidationUtil.convertBigDecimal(mtdAgeTo) );
//				obj.setMtdPolicytermFm( ValidationUtil.convertBigDecimal(mtdPolicytermFm) );
//				obj.setMtdPolicyTermTo( ValidationUtil.convertBigDecimal(mtdPolicyTermTo) );
//				obj.setMtdNoSeatsFm( ValidationUtil.convertBigDecimal(mtdNoSeatsFm) );
//				obj.setMtdNoSeatsTo( ValidationUtil.convertBigDecimal(mtdNoSeatsTo) );
//				obj.setMtdSumAssuredLimitFm( ValidationUtil.convertBigDecimal(mtdSumAssuredLimitFm) );
//				obj.setMtdSumAssuredLimitTo(ValidationUtil.convertBigDecimal(mtdSumAssuredLimitTo) );
//				obj.setMtdMaturityAgeFm(ValidationUtil.convertBigDecimal(mtdMaturityAgeFm) );
//				obj.setMtdMaturityAgeTo( ValidationUtil.convertBigDecimal(mtdMaturityAgeTo) );
//				obj.setMtdHeightFm(ValidationUtil.convertBigDecimal(mtdHeightFm) );
//				obj.setMtdHeightto(ValidationUtil.convertBigDecimal(mtdHeightto) );
//				obj.setMtdWeightFm(ValidationUtil.convertBigDecimal(mtdWeightFm) );
//				obj.setMtdWeightTo(ValidationUtil.convertBigDecimal(mtdWeightTo) );
//				obj.setMtdInsuredTypeFmCode(mtdInsuredTypeFmCode);
//				obj.setMtdInsuredTypeToCode(mtdInsuredTypeToCode);
//				obj.setMtdChildAgeFm(ValidationUtil.convertBigDecimal(mtdChildAgeFm) );
//				obj.setMtdChildAgeTo(ValidationUtil.convertBigDecimal(mtdChildAgeTo) );
//				obj.setMtdAdultCntFm( ValidationUtil.convertBigDecimal(mtdAdultCntFm) );
//				obj.setMtdAdultCntTo(ValidationUtil.convertBigDecimal(mtdAdultCntTo) );
//				obj.setMtdChildCntFm(ValidationUtil.convertBigDecimal(mtdChildCntFm) );
//				obj.setMtdChildCntTo( ValidationUtil.convertBigDecimal(mtdChildCntTo) );
//				obj.setMtdOccFmCode(mtdOccFmCode);
//				obj.setMtdOccToCode(mtdOccToCode);
//				obj.setMtdPremFqFmCode(mtdPremFqFmCode);
//				obj.setMtdPremfqToCode(mtdPremfqToCode);
//				obj.setMtdPara01FmCode(mtdPara01FmCode);
//				obj.setMtdPara01ToCode(mtdPara01ToCode);
//				obj.setMtdPara02FmCode(mtdPara02FmCode);
//				obj.setMtdPara02ToCode(mtdPara02ToCode);
//				obj.setMtdPara03FmCode(mtdPara03FmCode);
//				obj.setMtdPara03ToCode(mtdPara03ToCode);
//				obj.setMtdPara04FmCode(ValidationUtil.convertBigDecimal(mtdPara04FmCode) );
//				obj.setMtdPara04ToCode(ValidationUtil.convertBigDecimal(mtdPara04ToCode) );
//				obj.setMtdPara05FmCode(ValidationUtil.convertBigDecimal(mtdPara05FmCode) );
//				obj.setMtdPara05ToCode(ValidationUtil.convertBigDecimal(mtdPara05ToCode) );
//				obj.setMtdPara06FmCode(mtdPara06FmCode);
//				obj.setMtdPara06ToCode(mtdPara06ToCode);
//				obj.setMtdPara07FmCode(mtdPara07FmCode);
//				obj.setMtdPara07ToCode(mtdPara07ToCode);
//				obj.setMtdPara08FmCode(mtdPara08FmCode);
//				obj.setMtdPara08ToCode(mtdPara08ToCode);
//				obj.setMtdPremRate(ValidationUtil.convertBigDecimal(mtdPremRate) );
//				obj.setMtdMinPremRate(ValidationUtil.convertBigDecimal(mtdMinPremRate) );
//				obj.setMtdMaxPremRate(ValidationUtil.convertBigDecimal(mtdMaxPremRate) );
//				obj.setMtdRiPremRate(ValidationUtil.convertBigDecimal(mtdRiPremRate) );
//				obj.setMtdRiPremRatePer(ValidationUtil.convertBigDecimal(mtdRiPremRatePer) );
//				obj.setMtdMinSiLc1(ValidationUtil.convertBigDecimal(mtdMinSiLc1) );
//				obj.setMtdMaxSiLc1(ValidationUtil.convertBigDecimal(mtdMaxSiLc1) );
//				obj.setMtdMinPremLc1( ValidationUtil.convertBigDecimal(mtdMinPremLc1) );
//				obj.setMtdMaxPremLc1(ValidationUtil.convertBigDecimal(mtdMaxPremLc1) );
//				obj.setMtdDfltSi(ValidationUtil.convertBigDecimal(mtdDfltSi) );
//				obj.setMtdDiscCode1(mtdDiscCode1);
//				obj.setMtdDisc1Value(ValidationUtil.convertBigDecimal(mtdDisc1Value) );
//				obj.setMtdDiscCode2(mtdDiscCode2);
//				obj.setMtdDisc2Value(ValidationUtil.convertBigDecimal(mtdDisc2Value) );
//				obj.setMtdDiscCode3(mtdDiscCode3);
//				obj.setMtdDisc3Value(ValidationUtil.convertBigDecimal(mtdDisc3Value) );
//				obj.setMtdDiscCode4(mtdDiscCode4);
//				obj.setMtdDisc4Value(ValidationUtil.convertBigDecimal(mtdDisc4Value) );
//				obj.setMtdDiscCode5(mtdDiscCode5);
//				obj.setMtdDisc5Value(ValidationUtil.convertBigDecimal(mtdDisc5Value) );
//				obj.setMtdLoadCode1(mtdLoadCode1);
//				obj.setMtdLoad1Value(ValidationUtil.convertBigDecimal(mtdLoad1Value) );
//				obj.setMtdLoadCode2(mtdLoadCode2);
//				obj.setMtdLoad2Value(ValidationUtil.convertBigDecimal(mtdLoad2Value) );
//				obj.setMtdLoadCode3(mtdLoadCode3);
//				obj.setMtdLoad3Value(ValidationUtil.convertBigDecimal(mtdLoad3Value) );
//				obj.setMtdDedCode1(mtdDedCode1);
//				obj.setMtdDed1Value(ValidationUtil.convertBigDecimal(mtdDed1Value) );
//				obj.setMtdDedCode2(mtdDedCode2);
//				obj.setMtdDed2Value(ValidationUtil.convertBigDecimal(mtdDed2Value) );
//				obj.setMtdDedCode3(mtdDedCode3);
//				obj.setMtdDed3Value(ValidationUtil.convertBigDecimal(mtdDed3Value) );
//				obj.setMtdDedCode4(mtdDedCode4);
//				obj.setMtdDed4Value(ValidationUtil.convertBigDecimal(mtdDed4Value) );
//				}
//				
//				if (errors.size() > 0) {
//
//					String errorMessage = errors.stream().map(a -> String.valueOf(a)).collect(Collectors.joining(", "));
//					obj.setRemarks(errorMessage);
//					list.add(obj);
//					errorRecords++;
//
//				} else {
//
//					tariffLifeService.saveorupdate(obj);
//					uploadRecords++;
//
//				}
//
//				value.setTariffLifeList(list);
//				value.setErrorRecords(errorRecords);
//				value.setTotalRecords(totalRecords);
//				value.setUploadRecords(uploadRecords);
//
//			}
//		} catch (IOException  | ParseException e) {
//			
//			e.printStackTrace();
//
//		}
//		return value;
//
//	}
//
//}
