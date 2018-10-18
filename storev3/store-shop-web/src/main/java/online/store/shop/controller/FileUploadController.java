package online.store.shop.controller;


import entity.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ustil.FastDFSClient;


@RestController
public class FileUploadController {

    @Value("${FILE_SERVER_URL}")
    private String FILE_SERVER_URL;

    @RequestMapping("fileUpload")
    public Result fileUpload(MultipartFile file){
        try{
        String originalFilename = file.getOriginalFilename();
        String extName=originalFilename.substring(originalFilename.lastIndexOf('.')+1);
        FastDFSClient fastDFSClient=new FastDFSClient("classpath:config/fdfs_client.conf");
        String str = fastDFSClient.uploadFile(file.getBytes(), extName);
        String fileURL=FILE_SERVER_URL+str;
        return new Result(true,fileURL);}catch (Exception e){
            e.printStackTrace();
            return new Result(false,"上传失败");
        }
    }
}
