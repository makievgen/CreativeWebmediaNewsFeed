
package com.example.ram1991.creativewebmedianewsfeed.interactors.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pagination {

    @SerializedName("TotalPages")
    @Expose
    private String TotalPages;
    @SerializedName("PageNo")
    @Expose
    private String PageNo;
    @SerializedName("PerPage")
    @Expose
    private String PerPage;
    @SerializedName("WebURL")
    @Expose
    private String WebURL;

    /**
     * 
     * @return
     *     The TotalPages
     */
    public String getTotalPages() {
        return TotalPages;
    }

    /**
     * 
     * @param TotalPages
     *     The TotalPages
     */
    public void setTotalPages(String TotalPages) {
        this.TotalPages = TotalPages;
    }

    /**
     * 
     * @return
     *     The PageNo
     */
    public String getPageNo() {
        return PageNo;
    }

    /**
     * 
     * @param PageNo
     *     The PageNo
     */
    public void setPageNo(String PageNo) {
        this.PageNo = PageNo;
    }

    /**
     * 
     * @return
     *     The PerPage
     */
    public String getPerPage() {
        return PerPage;
    }

    /**
     * 
     * @param PerPage
     *     The PerPage
     */
    public void setPerPage(String PerPage) {
        this.PerPage = PerPage;
    }

    /**
     * 
     * @return
     *     The WebURL
     */
    public String getWebURL() {
        return WebURL;
    }

    /**
     * 
     * @param WebURL
     *     The WebURL
     */
    public void setWebURL(String WebURL) {
        this.WebURL = WebURL;
    }

}
