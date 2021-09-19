<h1>Step 1</h1>
<p>Navigate to the app section in your dashboard and create a new app ( you can create one directly from here ) or continue with an existing app</p>
<h1>Step 2</h1>
You need to setup your callback url for in the app dashboard before it can test it.
<h1>Callback parameters</h1>
<table>
  <tr>
    <th>Parameter</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>uid</td>
    <td>User id provided to us by you</td>
  </tr>
  <tr>
    <td>amount</td>
    <td>Amount (in your currency) user completed</td>
  </tr>
  <tr>
`   <td>transaction_id</td>
    <td>ID assigned to this transaction (in cases of chargeback) or it needs to be refrenced</td>
  </tr>
</table>
<h1>Install Android SDK. Add this to your build.gradle file</h1>

```
allprojects { 
   repositories { 
        ... 
        maven { url 'https://jitpack.io' }
   }
}
```

<h1>Add dependencies</h1>

```
dependencies { 
   ... 
   implementation 'com.github.gosclique:gosclique-android:{version}' }
}
```

<h1>Initialize Gosclique into your activity. Get your keys from your Gosclique <a href="https://gosclique.com/app">dashboard</a></h1>

```
@Override { 
   protected void onCreate(Bundle savedInstanceState) { 
      super.onCreate(savedInstanceState);
      ... 
      Gosclique.getInstance().init('YOUR_APP_ID', 'YOUR_USER_ID', 'CONTEXT';    
      ...
   }
}
```
<h1>Initialization parameters</h1>

<table>
  <tr>
    <th>Parameter</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>App ID</td>
    <td>Unique ID assigned to your app. You would find this in your app dashboard</td>
  </tr>
  <tr>
    <td>Context</td>
    <td>Activity to be passed</td>
  </tr>
  <tr>
    <td>User id</td>
    <td>Unique id which you should provide to us so you can track the users callback</td>
  </tr>
</table>


<h1>Show your user available surveys</h1>

```
@Override { 
     public void onClick(View v) { 
         Gosclique.getInstance().showSurveyPanel(new ShowCallback() {
           @Override 
              public void success() {      
                 Toast.makeText(MainActivity.this, R.string.opened, Toast.LENGTH_SHORT).show();
              }
           @Override 
              public void fail(String err) { 
                 Toast.makeText(MainActivity.this, err, Toast.LENGTH_SHORT).show();      
              }     
         });
      }
    ...
}}
```


<p>Contact us on <a className="text-red" href="mailto:contact@gosclique.com">contact@gosclique.com</a> if you need our help</p>
