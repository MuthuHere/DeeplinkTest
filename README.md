# DeeplinkTest
Create your dynamic link in easy way(Android)

### create long link with firebase SDK 

      String longLink  = "https://referearnpro.page.link/?"+
              "link=https://www.yoursite.com/"+
              "&apn="+ getPackageName()+
              "&stitle="+"My Link"+
              "&sd="+"Reward given CddSdcc"+
              "&si="+"https://cdn.pixabay.com/photo/2015/06/19/21/24/the-road-815297__340.jpg";

### creaet long link by Manual way with custom params
  
    DynamicLink dynamicLink = FirebaseDynamicLinks.getInstance().createDynamicLink()
        .setLink(Uri.parse("https://www.example.com/"))
        .setDynamicLinkDomain("example.page.link")  // use this code and don't use https:// here
        .setAndroidParameters(new DynamicLink.AndroidParameters.Builder().build())
        .setIosParameters(new DynamicLink.IosParameters.Builder("com.example.ios").build())
        .buildDynamicLink();
        Uri dynamicLinkUri = dynamicLink.getUri(); 
    
    
### shotern your long url using Firebase

No matter how you created your link. Means, you may used firebase one or Manual one. But you can shorten it via firebase
    
        Task<ShortDynamicLink> shortLinkTask = FirebaseDynamicLinks.getInstance().createDynamicLink()
        .setLink(Uri.parse("https://www.example.com/")) 
        .setDynamicLinkDomain("example.page.link")
        .buildShortDynamicLink()
        .addOnCompleteListener(this, new OnCompleteListener<ShortDynamicLink>() {
            @Override
            public void onComplete(@NonNull Task<ShortDynamicLink> task) {
                if (task.isSuccessful()) {
                    // Short link created
                    Uri shortLink = task.getResult().getShortLink();
                    Uri flowchartLink = task.getResult().getPreviewLink();
                     
                   Log.e("main ", "short link "+ shortLink.toString());
                   // your short link is  shortLink.tostring()
                } else {
                    // Error
                       Log.e("main", " error "+task.getException() );
                }
            }
        })
        
        
Happy coding:)
