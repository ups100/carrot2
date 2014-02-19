
/*
 * Carrot2 project.
 *
 * Copyright (C) 2002-2014, Dawid Weiss, Stanisław Osiński.
 * All rights reserved.
 *
 * Refer to the full license file "carrot2.LICENSE"
 * in the root folder of the repository checkout or at:
 * http://www.carrot2.org/carrot2.LICENSE
 */

package org.carrot2.webapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;

/**
 * Processes search requests.
 */
@SuppressWarnings("serial")
public class ImageDataEchoServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        String content = req.getParameter("content");
        
        String prefix = "data:image/png;base64,";
        if (content.startsWith(prefix)) {
            content = content.substring(prefix.length());

            resp.setContentType("application/octet-stream");
            resp.setHeader("Content-Disposition", "attachment");
            resp.getOutputStream().write(Base64.decodeBase64(content));
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Content is not image data.");
        }
    }
}
