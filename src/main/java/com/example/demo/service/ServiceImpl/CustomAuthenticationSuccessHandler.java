//package com.example.demo.service.ServiceImpl;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.web.DefaultRedirectStrategy;
//import org.springframework.security.web.RedirectStrategy;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Collection;
//
///**
// * Created by saniya on 31/5/17.
// */
//@Component
//public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler  {
//
//    private RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
//
//
//             for (GrantedAuthority auth : authentication.getAuthorities()) {
//                 if ("ROLE_Admin".equals(auth.getAuthority())){
//                     try{redirectStrategy.sendRedirect(httpServletRequest ,httpServletResponse,"/inventory.html");
//
//                     }catch (  Exception e){
//                         e.getMessage();
//                     }
//                 }
//
////                 if ("ROLE_PO".equals(auth.getAuthority())){
////                     try{redirectStrategy.sendRedirect("/admin");
////
////                     }catch (  Exception e){
////                         e.getMessage();
////                     }
////                 }
////
////                 if ("ROLE_Production".equals(auth.getAuthority())){
////                     try{redirectStrategy.sendRedirect("/admin");
////
////                     }catch (  Exception e){
////                         e.getMessage();
////                     }
////                 }
//             }
//
//
//
//
//
//
//
//    }
//}
