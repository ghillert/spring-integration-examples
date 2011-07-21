/*
 * Copyright 2002-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hillert.si;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.io.FilenameUtils;
import org.springframework.integration.Message;

/**
 *
 */
public class HeaderEnricherHandler {

	private transient final SimpleDateFormat dateFormat = new SimpleDateFormat("HH_mm_ss", Locale.ENGLISH);
	
    /**
     * 
     */
    public String enrichFilenameHeader(final Message<File> inputMessage) {

        final File inputFile = inputMessage.getPayload();
        final String filename = inputFile.getName();
        final String fileExtension = FilenameUtils.getExtension(filename);
        final Integer priority = inputMessage.getHeaders().getPriority();

        return dateFormat.format(new Date()) + "_Prio-" + priority + "_" + filename + "." + fileExtension;

    }

}
