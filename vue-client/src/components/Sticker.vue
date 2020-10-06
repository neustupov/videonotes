<template>
  <div class="row">
    <div class="col-md-auto align-self-center">
        <div class="row justify-content-md-center">
          <a :href="'/editSticker/' + sticker.id"
             class="btn btn-outline-primary btn-sm m-1" role="button"
             aria-pressed="true">Edit sticker</a>
        </div>
        <div class="row justify-content-md-center">
          <a :href="'/addNotes/' + sticker.id"
             class="btn btn-outline-primary btn-sm m-1" role="button"
             aria-pressed="true">Add note</a>
        </div>
      </div>
    <div class="card" style="width: 18rem;">
      <div class="card-header">
        {{ sticker.title }}
      </div>
      <ul class="list-group list-group-flush">
        <Notes :notes="sticker.notes"/>
      </ul>
    </div>
  </div>
</template>

<script>
  import Notes from "./Notes";

  export default {
    name: "sticker",
    props: ['sticker'],
    components: {Notes},
    data() {
      return {};
    },
    methods: {
      /*getBoard(id) {
        BoardDataService.get(id)
        .then(response => {
          this.currentBoard = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
      },

      updateBoard() {
        BoardDataService.update(this.currentBoard.id, this.currentBoard)
        .then(response => {
          console.log(response.data);
          this.message = 'The board was updated successfully!';
        })
        .catch(e => {
          console.log(e);
        });
      },

      deleteBoard() {
        BoardDataService.delete(this.currentBoard.id)
        .then(response => {
          console.log(response.data);
          this.$router.push({ name: "tutorials" });
        })
        .catch(e => {
          console.log(e);
        });
      }*/
    },
    mounted() {
      console.log(this.sticker);
    }
  };
</script>