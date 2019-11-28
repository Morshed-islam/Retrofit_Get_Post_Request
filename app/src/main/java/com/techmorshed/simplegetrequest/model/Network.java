package com.techmorshed.simplegetrequest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Network {

    @SerializedName("images")
    @Expose
    private List<Image> images = null;

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }


    public class Image{
        @SerializedName("startdate")
        @Expose
        private String startdate;
        @SerializedName("fullstartdate")
        @Expose
        private String fullstartdate;
        @SerializedName("enddate")
        @Expose
        private String enddate;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("urlbase")
        @Expose
        private String urlbase;
        @SerializedName("copyright")
        @Expose
        private String copyright;
        @SerializedName("copyrightlink")
        @Expose
        private String copyrightlink;
        @SerializedName("quiz")
        @Expose
        private String quiz;
        @SerializedName("wp")
        @Expose
        private Boolean wp;
        @SerializedName("hsh")
        @Expose
        private String hsh;
        @SerializedName("drk")
        @Expose
        private Integer drk;
        @SerializedName("top")
        @Expose
        private Integer top;
        @SerializedName("bot")
        @Expose
        private Integer bot;
        @SerializedName("hs")
        @Expose
        private List<Object> hs = null;

        public String getStartdate() {
            return startdate;
        }

        public void setStartdate(String startdate) {
            this.startdate = startdate;
        }

        public String getFullstartdate() {
            return fullstartdate;
        }

        public void setFullstartdate(String fullstartdate) {
            this.fullstartdate = fullstartdate;
        }

        public String getEnddate() {
            return enddate;
        }

        public void setEnddate(String enddate) {
            this.enddate = enddate;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrlbase() {
            return urlbase;
        }

        public void setUrlbase(String urlbase) {
            this.urlbase = urlbase;
        }

        public String getCopyright() {
            return copyright;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public String getCopyrightlink() {
            return copyrightlink;
        }

        public void setCopyrightlink(String copyrightlink) {
            this.copyrightlink = copyrightlink;
        }

        public String getQuiz() {
            return quiz;
        }

        public void setQuiz(String quiz) {
            this.quiz = quiz;
        }

        public Boolean getWp() {
            return wp;
        }

        public void setWp(Boolean wp) {
            this.wp = wp;
        }

        public String getHsh() {
            return hsh;
        }

        public void setHsh(String hsh) {
            this.hsh = hsh;
        }

        public Integer getDrk() {
            return drk;
        }

        public void setDrk(Integer drk) {
            this.drk = drk;
        }

        public Integer getTop() {
            return top;
        }

        public void setTop(Integer top) {
            this.top = top;
        }

        public Integer getBot() {
            return bot;
        }

        public void setBot(Integer bot) {
            this.bot = bot;
        }

        public List<Object> getHs() {
            return hs;
        }

        public void setHs(List<Object> hs) {
            this.hs = hs;
        }

        @Override
        public String toString() {
            return "Image{" +
                    "startdate='" + startdate + '\'' +
                    ", fullstartdate='" + fullstartdate + '\'' +
                    ", enddate='" + enddate + '\'' +
                    ", url='" + url + '\'' +
                    ", urlbase='" + urlbase + '\'' +
                    ", copyright='" + copyright + '\'' +
                    ", copyrightlink='" + copyrightlink + '\'' +
                    ", quiz='" + quiz + '\'' +
                    ", wp=" + wp +
                    ", hsh='" + hsh + '\'' +
                    ", drk=" + drk +
                    ", top=" + top +
                    ", bot=" + bot +
                    ", hs=" + hs +
                    '}';
        }


    }
}
