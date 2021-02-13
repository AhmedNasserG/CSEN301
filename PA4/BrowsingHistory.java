package CSEN301.PA4;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class BrowsingHistory {
    class Link {
        String url;
        String date;//  Format  YYYY -MM -DD
        int frequency;//  number  of  times a url  has  been  visited

        public Link(String url) {
            this.url = url;
            this.frequency = 0;
            // gets  the  current  date
            Calendar cal = Calendar.getInstance();
            Date calDate = cal.getTime();
            // and  convert  it into YYYY -MM-DD
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy -MM-dd");
            try {
                date = format1.format(calDate);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public Link(String url, int frequency) {
            this(url);
            this.frequency = frequency;
        }

        public String toString() {
            return url + "␣" + date + "␣frequency␣" + frequency;
        }
    }

    StackObj stack;

    BrowsingHistory(int maxSize) {
        stack = new StackObj(maxSize);
    }

    void add(String url) {
        int urlFrequency = 0;
        Link currentLink;
        StackObj temp = new StackObj(stack.size());
        while (!stack.isEmpty()) {
            currentLink = (Link) stack.pop();
            if (currentLink.url.equals(url)) {
                urlFrequency = currentLink.frequency;
                break;
            }
            temp.push(currentLink);
        }
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        stack.push(new Link(url, ++urlFrequency));
    }

    void removeLast() {
        if (!stack.isEmpty()){
            stack.pop();
        }
    }

    void removeLast(String date) {
        Link currentLink;
        StackObj temp = new StackObj(stack.size());
        while (!stack.isEmpty()) {
            currentLink = (Link) stack.pop();
            if (!currentLink.date.equals(date)) {
                temp.push(currentLink);
            }
        }
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    int getNumberOfLinks() {
        return stack.size();
    }

    String search() {
        String maxUrl = "";
        int max = 0;
        Link currentLink;
        StackObj temp = new StackObj(stack.size());
        while (!stack.isEmpty()) {
            currentLink = (Link) stack.pop();
            if (max < currentLink.frequency) {
                max = currentLink.frequency;
                maxUrl = currentLink.url;
            }
        }
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        return maxUrl;
    }

    public void printHistory() {
        stack.printStack();
    }

    public static void main(String[] args) {
        BrowsingHistory browsingHistory = new BrowsingHistory(1000);
        browsingHistory.add("https ://www.google.com/");
        browsingHistory.add("http ://www.youtube.com/");
        browsingHistory.add("https ://www.google.com/");
        System.out.println("Currect␣browsing␣history:");
        browsingHistory.printHistory();
        System.out.println("Most␣viewed␣so␣far␣is␣" + browsingHistory.search());
        browsingHistory.removeLast("2014 -10 -07");
        System.out.println("Currect␣browsing␣history:");
        browsingHistory.printHistory();
        browsingHistory.add("http ://www.facebook.com/");
        browsingHistory.add("http ://www.youtube.com/");
        browsingHistory.add("https ://www.google.com/");
        browsingHistory.add("http ://met.guc.edu.eg/");
        browsingHistory.add("http ://www.youtube.com/");
        browsingHistory.add("http ://met.guc.edu.eg/");
        browsingHistory.add("http ://met.guc.edu.eg/");
        System.out.println("Currect␣browsing␣history:");
        browsingHistory.printHistory();
        System.out.println("Most␣viewed␣so␣far␣is␣" + browsingHistory.search());
        browsingHistory.removeLast();
        browsingHistory.removeLast();
        System.out.println("Currect␣browsing␣history:");
        browsingHistory.printHistory();
        System.out.println("Most␣viewed␣so␣far␣is␣" + browsingHistory.search());
    }
}
