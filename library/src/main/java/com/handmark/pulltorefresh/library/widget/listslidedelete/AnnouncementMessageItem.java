package com.handmark.pulltorefresh.library.widget.listslidedelete;

public class AnnouncementMessageItem  extends MessageItem implements java.io.Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public String notesContent;
    public String createTime;
    /*public SlideView slideView;
    public String id;*/
    public int isDeleted;
    public String memberName;
    
    public String getNotesContent()
    {
        return notesContent;
    }
    public void setNotesContent(String notesContent)
    {
        this.notesContent = notesContent;
    }
    
    public String getcreateTime()
    {
        return createTime;
    }
    public void setcreateTime(String createTime)
    {
        this.createTime = createTime;
    }
    
    public String getid()
    {
        return id;
    }
    public void setid(String id)
    {
        this.id = id;
    }
    
    public SlideView getSlideView()
    {
        return slideView;
    }
    public void setSlideView(SlideView slideView)
    {
        this.slideView = slideView;
    }
    
    public String getmemberName()
    {
        return createTime;
    }
    public void setmemberName(String memberName)
    {
        this.memberName = memberName;
    }
    
    public int getisDeleted()
    {
        return isDeleted;
    }
    public void setisDeleted(int isDeleted)
    {
        this.isDeleted = isDeleted;
    }
    
}