package com.ort.ortnct.util;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
public class ConvertoBase
{
    public String convertToBase64 (MultipartFile file)
    {

        byte[] fileContent = new byte[0];
        try
        {
            fileContent = file.getBytes();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        return encodedString;
    }
}
