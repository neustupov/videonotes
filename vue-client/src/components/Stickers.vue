<template>
  <div class="list row">
    <div class="col-md-6">
      <AddSticker/>
    </div>
    <div class="col-md-6">
      <h4>Stickers List</h4>
      <ul class="list-group">
        <li class="list-group-item"
            :class="{ active: index === currentIndex }"
            v-for="(sticker, index) in stickers"
            :key="index"
            @click="setActiveSticker(sticker, index)"
        >
          {{ sticker.title }}
        </li>
      </ul>
    </div>
    <div class="col-md-6">
      <div v-if="currentSticker">
        <h4>Sticker</h4>
        <div>
          <label><strong>Title:</strong></label> {{ currentSticker.title }}
        </div>

        <a class="badge badge-warning"
           :href="'/stickers/' + currentSticker.id"
        >
          Edit
        </a>
      </div>
      <div v-else>
        <br/>
        <p>Please click on a Sticker...</p>
      </div>
    </div>
  </div>
</template>

<script>
  import StickerDataService from "../services/StickerDataService";
  import AddSticker from "./AddSticker";

  export default {
    components: {
      AddSticker
    },
    name: "stickers-list",
    props:['currentBoard'],
    data() {
      return {
        stickers: [],
        currentSticker: null,
        currentIndex: -1,
        title: ""
      };
    },
    methods: {
      fetchData() {
        StickerDataService.getAll(this.currentBoard.board.id)
        .then(response => {
          this.stickers = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
      },

      refreshList() {
        this.fetchData();
        this.currentSticker = null;
        this.currentIndex = -1;
      },

      setActiveSticker(sticker, index) {
        this.currentSticker = sticker;
        this.currentIndex = index;
      }
    },

    mounted() {
      this.fetchData();
    }
  }
</script>

<style>
  .list {
    text-align: left;
    max-width: 750px;
    margin: auto;
  }
</style>