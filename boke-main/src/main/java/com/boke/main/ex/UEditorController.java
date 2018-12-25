package com.boke.main.ex;

import com.boke.main.ueditor.ActionEnter;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by ldb on 2017/4/9.
 */
@Controller
@RequestMapping("ueditor")
public class UEditorController {


    @RequestMapping("/index")
    private String showPage() {
        return "index";
    }

    @RequestMapping(value = "/exec")
    public ResponseEntity config(HttpServletRequest request, HttpServletResponse response) throws JSONException {
        response.setContentType("application/json");
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        String exec = new ActionEnter(request, rootPath).exec();
        return new ResponseEntity(exec, HttpStatus.OK);


    }
}
