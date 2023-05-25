package com.taskBoard.core.Base;

import com.taskBoard.Modules.Group.Controllers.GroupController;
import com.taskBoard.Modules.Group.Views.Views;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMappingJacksonResponseBodyAdvice;

@ControllerAdvice(assignableTypes = GroupController.class)
public class ControllerAdviceResponse extends AbstractMappingJacksonResponseBodyAdvice {

    @Override
    protected void beforeBodyWriteInternal(MappingJacksonValue bodyContainer, MediaType contentType, MethodParameter returnType,
                                           ServerHttpRequest req, ServerHttpResponse res) {
        ServletServerHttpRequest request = (ServletServerHttpRequest)req;
        String view = request.getServletRequest().getParameter("details");
        if ("all".equals(view)) {
            bodyContainer.setSerializationView(Views.GroupInfoDetails.class);
        }else{
            bodyContainer.setSerializationView(Views.GroupInfo.class);
        }
    }
}
