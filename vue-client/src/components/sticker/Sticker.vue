<template>
  <div class="row">
    <div class="col-md-auto align-self-center">
      <div class="row justify-content-md-center">
        <a :href="'/editSticker/' + sticker.id"
           class="btn btn-outline-primary btn-sm m-1" role="button"
           aria-pressed="true">Edit sticker</a>
      </div>
      <div class="row justify-content-md-center">
        <a :href="'/addNote/' + sticker.id"
           class="btn btn-outline-primary btn-sm m-1" role="button"
           aria-pressed="true">Add note</a>
      </div>
      <div class="row justify-content-md-center">
        <a :href="'/editNote/' + currentNote.id"
           class="btn btn-outline-primary btn-sm m-1" role="button"
           aria-pressed="true">Add note</a>
      </div>
    </div>
    <div class="card" style="width: 18rem;">
      <div class="card-header">
        {{ sticker.title }}
      </div>
      <ul class="list-group list-group-flush">
        <Notes :notes="sticker.notes" @set-current-note="setCurrentNote"/>
      </ul>
    </div>
  </div>
</template>

<script>
  import Notes from "../note/Notes";

  export default {
    name: "sticker",
    props: ['sticker'],
    components: {Notes},
    data() {
      return {
        currentNote: null
      };
    },
    methods: {},
    mounted() {
      console.log(this.sticker);
    },
    setCurrentNote(note) {
      this.currentNote = note;
    }
  };
</script>