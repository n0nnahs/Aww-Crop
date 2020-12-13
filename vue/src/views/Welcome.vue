<template id="welcome">
  <div id="main-grid" class="welcome">
    <div id="attractive-header">
            <img id="header-image" src="@/assets/Outstanding-Vegetable-Garden-Vectors-1.jpg" alt="Vegetable Garden">
            <h1 id="heading">Aww Crop! The Garden Planning App</h1>
        <div id="bananas">
            <div id="login">
              <router-link style="color: #4e2409;" v-bind:to="{ name: 'login' }">Have an account already? <span style="font-style:italic;font-weight:bold; color: #a53b58;"> Sign in.</span></router-link>
            </div>
            <div id="register">
              <router-link style="color: #4e2409;" v-bind:to="{ name: 'register' }">If not, click <span style="font-style:italic;font-weight:bold; color: #fe6f15;">here</span> to create one!</router-link>
            </div>
        </div>
    </div>
    <div id="info-columns">
      <div id="plan">
        <h3 id="p" >Plan your garden</h3>
          <p>
          <i class="fas fa-seedling"></i>
          Browse plants and vegetables<br> 
          <i class="fas fa-seedling"></i>
          Try our patented Graphplot™ feature!<br>
          <i class="fas fa-seedling"></i>
          Other cool stuff</p>
      </div>
      <div id="track">
        <h3 id="t" >Track your progress</h3>
          <p>
            <i class="fas fa-seedling"></i>
            Keep track of crop yields<br>
            <i class="fas fa-seedling"></i>
            Save notes for next year!<br>
            <i class="fas fa-seedling"></i>
            all your crops are belong to us</p>
      </div>
      <div id="shop">
        <h3 id="s" >Shop for supplies</h3>
          <p>
            <i class="fas fa-seedling"></i>
            Calculate how many seeds you need<br>
            <i class="fas fa-seedling"></i>
            Hello Josh!<br>
            <i class="fas fa-seedling"></i>
            Discover something new!</p>
      </div>
    </div>
    <div id=footer>
      <h6>© 2020 Aww Crop! LLC </h6>
    </div>
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>

<style scoped>
i{
color: green;
}
#attractive-header{
  grid-area: attractive-header;
  text-align: center;
}
#footer{
  grid-area: footer;
  text-align: left;
  background-color: #5f2b0a; 
  padding-left: 10px;
  padding-bottom: 10px;
}
#login{
  grid-area: login;
  text-align: center;
}
#register{
  grid-area: register;
  text-align: center;
}
#plan{
  grid-area: plan;
  text-align: left;
  margin: 20px;
}
#track{
  grid-area: track;
  text-align: left;
  margin: 20px;
}
#shop{
  grid-area: shop;
  text-align: left;
  margin: 20px;
}
#main-grid {
  display: grid;
  grid-template-columns:1fr;
  grid-template-areas:
    "attractive-header"
    "info-columns"
    "footer";
  background-color: #4e2409;
}
#info-columns {
  grid-area: info-columns;
  background-color:#4e2409;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas:
    "plan track shop";
  background-color: #4e2409;

}
#header-image{
  width: 100%;
  position: relative; 
}
#heading{
  width: 100%;
  color: #4e2409;
  font-size: 72px;
  position: absolute;
  top: 15%;
  left: 50%;
  transform: translate(-50%, -50%);
  padding-bottom: 10px;
}
#bananas{
width: 50%;
font-size: 24px;
position: absolute;
top: 30%;
left: 50%;
transform: translate(-50%, -50%);
}
h3{
  font-size: 32px;
  padding-bottom: 15 px;
}
p{
  font-size: 16 px;
}
h6{
  padding-top: 20px;
  font-size: 10 px;
  color:#b24747;
}
h3{
  font-size: 32px;
  padding-bottom: 15 px;
}
#info-columns{
  font-size: 12;
}
/*mid-sized*/
@media (max-width: 1200px){

#heading{
  width: 100%;
  color: #4e2409;
  font-size: 72px;
  position: absolute;
  top: 20%;
  left: 50%;
  transform: translate(-50%, -50%);
  padding-bottom: 10px;
}
#bananas{
width: 50%;
font-size: 24px;
position: absolute;
top: 45%;
left: 50%;
transform: translate(-50%, -50%);
background-color: rgba(245, 249, 250, 0.7);
}

}


/*tablets*/
@media (max-width: 900px){
      #main-grid {
        grid-template-columns: 100%;
        grid-template-areas:
            "attractive-header"
            "info-columns"
            "footer";
      }
      #info-columns {
        grid-template-columns: 100%;
        grid-template-areas:
            "plan"
            "track"
            "shop";
      }
      #heading{
        width: 100%;
        color: #4e2409;
        font-size: 48px;
        position: absolute;
        top: 10%;
        left: 50%;
        transform: translate(-50%, -50%);
        padding-bottom: 10px;
      }
      #bananas{
        width: 75%;
        font-size: 20px;
        position: absolute;
        top: 25%;
        left: 50%;
        transform: translate(-50%, -50%);
        background-color: rgba(245, 249, 250, 0.7);
      }
      #footer{
        grid-area: footer;
        text-align: center;
      }
}
/*mobile*/
@media (max-width: 450px){
      #main-grid {
        grid-template-columns: 100%;
        grid-template-areas:
            "attractive-header"
            "info-columns"
            "footer";
      }
      #info-columns {
        grid-template-columns: 100%;
        grid-template-areas:
            "plan"
            "track"
            "shop";
     }
     #heading{
        width: 100%;
        color: #4e2409;
        font-size: 36px;
        position: absolute;
        top: 10%;
        left: 50%;
        transform: translate(-50%, -50%);
        padding-bottom: 10px;
     }
    #bananas{
        width: 100%;
        font-size: 14px;
        position: absolute;
        top: 22%;
        left: 50%;
        transform: translate(-50%, -50%);
    }
    #footer{
        grid-area: footer;
        text-align: center;
    }  
}
/*extra small mobile*/
@media (max-width: 325px){
    #main-grid {
        grid-template-columns: 100%;
        grid-template-areas:
            "attractive-header"
            "info-columns"
            "footer";
    }
    #info-columns {
        grid-template-columns: 100%;
        grid-template-areas:
            "plan"
            "track"
            "shop";
    }
    #heading{
        width: 100%;
        color: #4e2409;
        font-size: 22px;
        position: absolute;
        top: 7%;
        left: 50%;
        transform: translate(-50%, -50%);
        padding-bottom: 10px;
    }
    #bananas{
        width: 100%;
        font-size: 12px;
        position: absolute;
        top: 15%;
        left: 50%;
        transform: translate(-50%, -50%);
    }
    #footer{
        grid-area: footer;
        text-align: center;
    }
}
</style>