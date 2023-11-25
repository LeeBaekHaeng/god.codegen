package egovframework.com.cmm.web;

import java.util.List;

import org.egovframe.rte.fdl.cryptography.EgovEnvCryptoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.FileVO;
import egovframework.com.cmm.util.EgovMybatisUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 파일 업로드 처리를 위한 컨트롤러 클래스
 * 
 * @author 컨트리뷰터팀 이백행
 * @since 2023-11-23
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일          수정자        수정내용
 *  ----------     --------    ---------------------------
 *  2023-11-23     이백행        최초 생성
 *
 *      </pre>
 */
@Controller
@RequiredArgsConstructor
@Slf4j
public class EgovFileUploadController {

	/**
	 * 데이터베이스 연결시 대한 항목을 암호화, 복호화
	 */
	private final EgovEnvCryptoService cryptoService;

	/**
	 * 파일정보의 관리를 위한 서비스 인터페이스
	 */
	private final EgovFileMngService fileMngService;

	/**
	 * 
	 */
	private final EgovFileMngUtil fileUtil;

	/**
	 * 파일 업로드 화면
	 * 
	 * @param encAtchFileId
	 * @param model
	 * @return
	 */
	@GetMapping("/cmm/fms/uploadFile.do")
	public String uploadFileView(final @RequestParam(name = "param_atchFileId", required = false) String encAtchFileId,
			final @ModelAttribute("searchVO") FileVO fileVO, final ModelMap model) {

		log.debug("encAtchFileId={}", encAtchFileId);

		if (EgovMybatisUtil.isNotEmpty(encAtchFileId)) {
			fileVO.setAtchFileId(cryptoService.decrypt(encAtchFileId));
		}

		if (log.isDebugEnabled()) {
			log.debug("decAtchFileId={}", fileVO.getAtchFileId());
		}

		return "egovframework/com/cmm/fms/EgovFileUpload";
	}

	/**
	 * 파일 업로드
	 * 
	 * @param multiRequest
	 * @param encAtchFileId
	 * @param fileVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/cmm/fms/uploadFile.do")
	public String uploadFile(final MultipartHttpServletRequest multiRequest,
			final @RequestParam(name = "param_atchFileId", required = false) String encAtchFileId, final String keyStr,
			final String storePath, final String fn, final @ModelAttribute("searchVO") FileVO fileVO,
			final ModelMap model) throws Exception {

		log.debug("encAtchFileId={}", encAtchFileId);

		if (EgovMybatisUtil.isNotEmpty(encAtchFileId)) {
			fileVO.setAtchFileId(cryptoService.decrypt(encAtchFileId));
		} else {
			fileVO.setAtchFileId(null);
		}

		if (log.isDebugEnabled()) {
			log.debug("decAtchFileId={}", fileVO.getAtchFileId());
		}

		String atchFileId = fileVO.getAtchFileId();

		final List<MultipartFile> files = multiRequest.getFiles("file_1");
		if (!files.isEmpty()) {
			if (atchFileId == null || "".equals(atchFileId)) {
				final List<FileVO> result = fileUtil.parseFileInf(files, keyStr, 0, atchFileId, storePath);
				atchFileId = fileMngService.insertFileInfs(result);
				if (EgovMybatisUtil.isNotEmpty(atchFileId)) {
					model.addAttribute("param_atchFileId", cryptoService.encrypt(atchFileId));
				} else {
					log.debug("atchFileId={}", atchFileId);
				}
			} else {
				final FileVO fvo = new FileVO();
				fvo.setAtchFileId(atchFileId);
				final int cnt = fileMngService.getMaxFileSN(fvo);
				final List<FileVO> _result = fileUtil.parseFileInf(files, keyStr, cnt, atchFileId, storePath);
				fileMngService.updateFileInfs(_result);
				model.addAttribute("param_atchFileId", encAtchFileId);
			}
		}

		model.addAttribute("keyStr", keyStr);
		model.addAttribute("storePath", storePath);
		model.addAttribute("fn", fn);

		return "redirect:/cmm/fms/uploadFile.do";
	}

}
