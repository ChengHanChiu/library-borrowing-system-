<script setup>
// import { defineProps, computed } from 'vue';

const props = defineProps({
  data: Object,
});

const showBook = (data) =>{
  emits('show', data )
}

const emits = defineEmits(['show'])
</script>

<template>
  <tr @click="showBook(data)" :id="'row-'+data.id">
    <th scope="row"><a :href="'#'+data.id">{{ data.id }}</a></th>
    <td><a :href="'#'" class="text-primary">{{ data.isbn }}</a></td>
    <!-- <td><a :href="'#'" class="text-primary">{{ data.status }}</a></td> -->
    <td>{{ data._links.name.href }}</td>
    <!-- <td>{{ data.status }}</td> -->
    <td>{{ data._links.author.href }}</td>
    <td><span :class="data.status">{{ data.status }}</span></td>
  </tr>
</template>

<style scoped>

</style>
