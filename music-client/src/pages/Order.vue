<template>
  <div class="home">
    <el-card class="box-card" style="width:100%">
      <el-container>
        <!-- <el-divider></el-divider> -->
        <el-container>
          <el-aside width="30%" style="background:LightYellow">
            <div class="fixed_div">
              <div v-for='(item,index) in musicOrderList' :key="index" class="catalog"  :class="{active:index == isSelect}" @click="changeMusicOrder(index)"><h1>{{ item.name }}</h1></div>
            </div>
          </el-aside>
          <div class="divider"></div>
          <el-main class="side-main">
            <el-row>
                <el-col v-for="(item,index) in headerLogos" :key="index" :span="item.picImg!=null?4:8">
                  <div>
                    <img v-if="item.picImg!=null" :src="item.picImg" class="logo-img"/>
                    <h1 v-if="item.picImg==null" style="text-align:center" v-html="headerText"></h1>
                  </div>
                </el-col>
            </el-row>
            <template>
              <el-table
                :data="tableData"
                stripe
                style="width: 100%;background:DarkBlue">
                <el-table-column
                  prop="num"
                  width="100">
                </el-table-column>
                <el-table-column style="background:DarkBlue"
                  prop="name">
                </el-table-column>
              </el-table>
            </template>
          </el-main>
        </el-container>
      </el-container>
    </el-card>
  </div>
</template>

<script>
import Swiper from '../components/Swiper'
import { getMusicOrderList } from '../api/index'
import { headerLogos } from '../assets/data/headerLogo'
import { musicList } from '../assets/data/musicList'

export default {
  name: 'order',
  components: {
    Swiper
  },
  data () {
    return {
      headerLogos:[],
      musicList:[],
      headerText: "",
      currentMusicList: '',
      musicOrderList:[],
      
      tableData: [{
          num: 'A1001',
          name: '(24bit／352khz)2L唱片-母带样本'
        }, {
          num: 'A1002',
          name: '24bit／352khz)抒情钢琴Jan Gunnar Hoff - Stille Lys (Quiet Light)HDtracks'
        }, {
          num: 'A1003',
          name: '32bit／352khz-FLAC)[HM唱片] Berlioz - Symphonie fantastique - RCO, Daniele Gatti'
        }, {
          num: 'A1004',
          name: '[2xHD]Shostakovich-SymphoniesNos.2&15-RLPO,VasilyPetrenko(2012)'
        },{
          num: 'A1005',
          name: 'AnnaNetrebko,Abbado,MCO-SempreLibera(歌剧咏叹调精选专辑)'
        },{
          num: 'A1006',
          name: 'Arcadia-Andreas Scholl,Ottavio Dantone,Accademia Bizantina-Decca'
        },
        {
          num: 'A1006',
          name: 'Arcadia-Andreas Scholl,Ottavio Dantone,Accademia Bizantina-Decca'
        },
        {
          num: 'A1006',
          name: 'Arcadia-Andreas Scholl,Ottavio Dantone,Accademia Bizantina-Decca'
        },
        {
          num: 'A1006',
          name: 'Arcadia-Andreas Scholl,Ottavio Dantone,Accademia Bizantina-Decca'
        }]
    }
  },
  created () {
    this.headerLogos = headerLogos
    this.musicList = musicList
    this.currentCatalog = 0
    // 获取歌单列表
    this.getMusicOrderList()
  },
  methods: {
    getMusicOrderList () {
      getMusicOrderList()
        .then(res => {
          console.log(this.musicOrderList)
          this.musicOrderList = res
          this.changeMusicOrder(0)
        })
        .catch(err => {
          console.log(err)
        })
    },
    changeMusicOrder (index){
      this.isSelect = index
      this.headerText = this.musicOrderList[index].des
      this.currentMusicList = this.musicList[index].picImg
    }
  }
}
</script>

<style lang="scss" scoped>
@import '../assets/css/home.scss';
  .side-main {
    background:DarkBlue;
    color:white
  }
  .logo-img {
    height: 100%;
    width: 100%;
  }
  .catalog {
    padding-top: 20px;
    padding-bottom: 1.5em;
    margin-left: 3em;
    font-size: 1.5em;
    color: red;
    cursor:pointer;
  }
  .logo-col {
    height: 10%;
  }

  .fixed_div{
    position:fixed;
  }
  .active {
    color: green;
  }
</style>
