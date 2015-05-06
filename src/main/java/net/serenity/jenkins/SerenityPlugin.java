/*
 * The MIT License
 * 
 * Copyright (c) 2011, Harald Wellmann
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.serenity.jenkins;

import hudson.Plugin;
import hudson.PluginWrapper;
import hudson.model.AbstractBuild;
import hudson.model.Hudson;

import java.io.File;

/**
 * Placeholder for plugin entry point. Explicit initialization is not required for now.
 * <p>
 * This class also acts as a container for methods used throughout the plugin.
 * 
 * @author Harald Wellmann
 * 
 */
public class SerenityPlugin extends Plugin {

    public static final String REPORT_FOLDER = "thucydidesReport";

    private static final String SERENITY_ICON_URL = "img/serenity48.jpeg";

    /**
     * Returns the Serenity report folder for a given build.
     * @param build current build
     * @return Serenity report folder
     */
    public static File getBuildReportFolder(AbstractBuild<?, ?> build) {
        assert build != null;
        return new File(build.getRootDir(), REPORT_FOLDER);
    }

    /**
     * Returns the path or URL to access web resources from this plugin.
     * @return resource path
     */
    public static String getPluginResourcePath() {
        PluginWrapper wrapper = Hudson.getInstance().getPluginManager()
                .getPlugin(SerenityPlugin.class);
        return "/plugin/" + wrapper.getShortName() + "/";
    }

    /**
     * Return the file name for the Serenity icon.
     * @return name of plugin resource, relative to Jenkins context root
     */
    public static String getIconFileName() {
        return getPluginResourcePath() + SERENITY_ICON_URL;
    }
}
