<template>
  <div class="container">
    <div class="container mt">
      <div class="row">
        <div class="col-md-auto align-self-center">
          <div class="row justify-content-md-center">
            <!--<button @click="this.BoardDataService.create" type="button" class="btn btn-outline-primary">Add board</button>-->
            <a href="/addBoard" class="btn btn-outline-primary btn-sm m-1" role="button"
               aria-pressed="true">Add board</a>
          </div>
          <div v-if="currentBoard">
            <div class="row justify-content-md-center">
              <a :href="'/editBoard/' + currentBoard.board.id"
                 class="btn btn-outline-primary btn-sm m-1" role="button"
                 aria-pressed="true">Edit board</a>
            </div>
            <div class="row justify-content-md-center">
              <a :href="'/addSticker/' + currentBoard.board.id" class="btn btn-outline-primary btn-sm m-1" role="button"
                 aria-pressed="true">Add sticker</a>
            </div>
          </div>
        </div>
        <div class="col align-content-start">
          <Boards @set-current-board="setCurrentBoard"/>
        </div>
      </div>
    </div>
    <div v-if="currentBoard" class="container mt">
      <div class="row">
        <div class="col-md-auto align-self-center">
          <Stickers :current-board='currentBoard'/>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import Boards from "./Boards";
  import Stickers from "./Stickers";

  export default {
    name: "Main",
    components: {Boards, Stickers},
    data() {
      return {
        currentBoard: null
      }
    },
    methods: {
      setCurrentBoard(board) {
        this.currentBoard = board;
      }
    }
  }

</script>