package org.BG.util.Aws_Cdn;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.DeleteObjectsRequest;
import com.amazonaws.services.s3.model.GetBucketLocationRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

@Service
public class Aws_Cdn_Service {
    @Resource(name = "aws.accessKey")
    private String accessKey;
    @Resource(name = "aws.secretKey")
    private String secretKey;
    @Resource(name = "aws.bucketName")
    private String bucketName;

    private AmazonS3 s3Client;


    @PostConstruct
    public void setS3Client() {
        try{
            AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

            s3Client = AmazonS3ClientBuilder.standard()
                    .withCredentials(new AWSStaticCredentialsProvider(credentials))
                    .withRegion(Regions.AP_NORTHEAST_2)
                    .build();

            System.out.println("생성 버킷 이름: " + bucketName);
            if(!s3Client.doesBucketExistV2(bucketName)){
                s3Client.createBucket(bucketName);

                // Verify that the bucket was created by retrieving it and checking its location.
                String bucketLocation = s3Client.getBucketLocation(new GetBucketLocationRequest(bucketName));
                System.out.println("Bucket location: " + bucketLocation);
            } else{
                System.out.println("amazonS3 Bucket Exist!!");
            }
        }catch (AmazonClientException e){
            // The call was transmitted successfully, but Amazon S3 couldn't process
            // it and returned an error response.
            e.printStackTrace();
        }
    }

    //파일 경로를 리턴
    public String FileUpload(String path, MultipartFile multipartFile) throws IOException {
        File file = multipartToFile(multipartFile);
        String awsCdnFilePath = path + genSaveFileName() + multipartFile.getOriginalFilename();
        s3Client.putObject(bucketName, awsCdnFilePath, file);
        file.delete();
        return awsCdnFilePath;
    }

    //jsonArray 형태로 파일 경로 리턴
    public String FileArrayUpload(String path, ArrayList<MultipartFile> multipartFileArrayList) throws IOException{
        JSONArray pathArrayList = new JSONArray();
        for(int i = 0; i < multipartFileArrayList.size(); i++){
            if(multipartFileArrayList.get(i) != null){
                String awsCdnFilePath = path + genSaveFileName() + multipartFileArrayList.get(i).getOriginalFilename();
                pathArrayList.add(awsCdnFilePath);
                File file = multipartToFile(multipartFileArrayList.get(i));

                s3Client.putObject(bucketName, awsCdnFilePath, file);
                file.delete();
            }
        }
        return pathArrayList.toJSONString();
    }

    //저장 경로 상대경로값 줘서 확인해보삼
    public void FileDownload(String downLoadLocalPath, String awsCdnFilePath, HttpServletRequest req) throws IOException {
        String destFilename = req.getSession().getServletContext().getRealPath("/") + downLoadLocalPath; //로컬 저장 경로
        S3Object s3object = s3Client.getObject(bucketName, awsCdnFilePath);    //#1 - 버킷에 있는 파일을 다운로드함
        S3ObjectInputStream inputStream = s3object.getObjectContent();
        FileUtils.copyInputStreamToFile(inputStream, new File(destFilename));  //#2 - 스트림을 파일로 저장함
    }

    public void FileDelete(String awsCdnFilePath) throws IOException{
        s3Client.deleteObject(bucketName, awsCdnFilePath); //#1 - 버킷에 있는 파일 하나 삭제
    }

    public void FileArrayDelete(String awsCdnFileArrayPath[]) throws IOException{
        DeleteObjectsRequest delObjReq = new DeleteObjectsRequest(bucketName).withKeys(awsCdnFileArrayPath);
        s3Client.deleteObjects(delObjReq); //#2 - 버킷에 있는 여러 파일 삭제
    }

    private File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException{
        File convFile = new File(multipart.getOriginalFilename());
        multipart.transferTo(convFile);
        return convFile;
    }

    // 현재 시간을 기준으로 이름 생성
    private String genSaveFileName() {
        String fileName = "";

        Calendar calendar = Calendar.getInstance();
        fileName += calendar.get(Calendar.YEAR);
        fileName += calendar.get(Calendar.MONTH);
        fileName += calendar.get(Calendar.DATE);
        fileName += calendar.get(Calendar.HOUR);
        fileName += calendar.get(Calendar.MINUTE);
        fileName += calendar.get(Calendar.SECOND);
        fileName += calendar.get(Calendar.MILLISECOND);

        return fileName;
    }
}
