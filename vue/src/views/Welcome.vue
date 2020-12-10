<template>
  <div id="main-grid" class="welcome">
    <div id="attractive-header">
            <img id="header-image" src="@/assets/Outstanding-Vegetable-Garden-Vectors-1.jpg" alt="Vegetable Garden">
            <h1 id="heading">Aww Crop! The Garden Planning App</h1>
        <div id="pineapples">
            <div id="login">
              <router-link style="color: #4e2409;" v-bind:to="{ name: 'login' }">Have an account already? <span style="font-style:italic;font-weight:bold"> Sign in.</span></router-link>
            </div>
            <div id="register">
              <router-link style="color: #4e2409;" v-bind:to="{ name: 'register' }">If not, click <span style="font-style:italic;font-weight:bold">here</span> to create one!</router-link>
            </div>
        </div>
    </div>
    <div id="info-columns">
      <div id="plan">
        <h3>Plan your garden</h3>
          <p>Find plants and vegetables that are suitable for your garden</p>
          <p>Figure out what goes where using our Graphplot™ feature</p>
          <p>Other cool stuff</p>
      </div>
      <div id="track">
        <h3>Track your progress</h3>
          <p>Keep track of crop yeilds</p>
          <p>Save notes of what works, and what doesn't</p>
          <p>all your crops are belong to us</p>
      </div>
      <div id="shop">
        <h3>Shop for supplies</h3>
          <p>Calculate how many seeds you need for your garden</p>
          <p>Get recommendations for seeds suitable for your garden</p>
          <p>Discover something new!</p>
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

#attractive-header{
  grid-area: attractive-header;
  text-align: center;
}
#footer{
  grid-area: footer;
  text-align: left;
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
  text-align: center;
}
#track{
  grid-area: track;
  text-align: center;
}
#shop{
  grid-area: shop;
  text-align: center;
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
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas:
    "plan track shop";
  text-align: center;
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
  top: 30%;
  left: 50%;
  transform: translate(-50%, -50%);
  padding-bottom: 10px;
}
#pineapples{
width: 100%;
font-size: 24px;
position: absolute;
top: 50%;
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

/*tablets*/
@media (max-width: 800px){
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
      #pineapples{
        width: 100%;
        font-size: 20px;
        position: absolute;
        top: 25%;
        left: 50%;
        transform: translate(-50%, -50%);
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
    #pineapples{
        width: 100%;
        font-size: 14px;
        position: absolute;
        top: 20%;
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
        top: 10%;
        left: 50%;
        transform: translate(-50%, -50%);
        padding-bottom: 10px;
    }
    #pineapples{
        width: 100%;
        font-size: 12px;
        position: absolute;
        top: 17%;
        left: 50%;
        transform: translate(-50%, -50%);
    }
    #footer{
        grid-area: footer;
        text-align: center;
    }
}
</style>