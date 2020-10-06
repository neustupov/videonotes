<template>
  <div class="list row">
    <div class="col-md-auto align-self-center">
      <div v-if="notes">
        <ul class="list-group">
          <li class="list-group-item"
              :class="{ active: index === currentIndex }"
              v-for="(note, index) in notes"
              :key="index"
              @click="setActiveNote(note, index)"
          >
            <Note :note='note'/>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
  import Note from "./Note";

  export default {
    name: "Notes",
    props: ['notes'],
    components: {Note},
    data() {
      return {
        currentNote: null,
        currentIndex: -1,
        description: ""
      };
    },
    methods: {
      setActiveNote(note, index) {
        this.currentNote = note;
        this.currentIndex = index;
      }
    }
  }
</script>

<style scoped>

</style>