// ------------------------------------------------------------------/classrooms------------------------------
// GET -retrive all
// GET -retrive all
fetch('/classrooms/').then(response => response.json().then(console.log))

// GET -retrive one
fetch('/classrooms/1').then(response => response.json().then(console.log))

// POST -create new one
fetch(
  '/classrooms', 
  { 
    method: 'POST', 
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ name: 'test room' })
  }
).then(result => result.json().then(console.log))

// PUT -update existing one
fetch(
  '/classrooms/10', 
  { 
    method: 'PUT', 
    headers: { 'Content-Type': 'application/json' }, 
    body: JSON.stringify({ name: 'UPDATED'})
  }
).then(result => result.json().then(console.log));

// DELETE -delete existing one
fetch('/classrooms/10', { method: 'DELETE' }).then(result => console.log(result))


// ------------------------------------------------------------------/subjects------------------------------
// GET -retrive all
fetch('/subjects/').then(response => response.json().then(console.log))

// GET -retrive one
fetch('/subjects/1').then(response => response.json().then(console.log))

// POST -create new one
fetch(
  '/subjects', 
  { 
    method: 'POST', 
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ name: 'test subject' })
  }
).then(result => result.json().then(console.log))

// PUT -update existing one
fetch(
  '/subjects/15', 
  { 
    method: 'PUT', 
    headers: { 'Content-Type': 'application/json' }, 
    body: JSON.stringify({ name: 'UPDATED'})
  }
).then(result => result.json().then(console.log));

// DELETE -delete existing one
fetch('/subjects/15', { method: 'DELETE' }).then(result => console.log(result))


// ------------------------------------------------------------------/teachers------------------------------
// GET -retrive all
fetch('/teachers/').then(response => response.json().then(console.log))

// GET -retrive one
fetch('/teachers/1').then(response => response.json().then(console.log))

// POST -create new one
fetch(
  '/teachers', 
  { 
    method: 'POST', 
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ firstName: 'Testor', middleName: 'Testovich', lastName: 'Testov' })
  }
).then(result => result.json().then(console.log))

// PUT -update existing one
fetch(
  '/teachers/18', 
  { 
    method: 'PUT', 
    headers: { 'Content-Type': 'application/json' }, 
    body: JSON.stringify({ firstName: 'Updator', middleName: 'Updatovich', lastName: 'Updatov' })
  }
).then(result => result.json().then(console.log));

// DELETE -delete existing one
fetch('/teachers/17', { method: 'DELETE' }).then(result => console.log(result))


// ------------------------------------------------------------------/groups------------------------------
// GET -retrive all
fetch('/groups/').then(response => response.json().then(console.log))

// GET -retrive one
fetch('/groups/1').then(response => response.json().then(console.log))

// POST -create new one
fetch(
  '/groups', 
  { 
    method: 'POST', 
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ name: 'test group' })
  }
).then(result => result.json().then(console.log))

// PUT -update existing one
fetch(
  '/groups/4', 
  { 
    method: 'PUT', 
    headers: { 'Content-Type': 'application/json' }, 
    body: JSON.stringify({ name: 'UPDATED'})
  }
).then(result => result.json().then(console.log));

// DELETE -delete existing one
fetch('/groups/4', { method: 'DELETE' }).then(result => console.log(result))


// ------------------------------------------------------------------/students------------------------------
// GET -retrive all
fetch('/students/').then(response => response.json().then(console.log))

// GET -retrive one
fetch('/students/1').then(response => response.json().then(console.log))

// POST -create new one
fetch(
  '/students', 
  { 
    method: 'POST', 
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ firstName: 'Testor', middleName: 'Testovich', lastName: 'Testov',  group: {id: 1, name: "K-3120"} })
  }
).then(result => result.json().then(console.log))

// PUT -update existing one
fetch(
  '/students/18', 
  { 
    method: 'PUT', 
    headers: { 'Content-Type': 'application/json' }, 
    body: JSON.stringify({ firstName: 'Updator', middleName: 'Updatovich', lastName: 'Updatov',  group: {id: 2, name: "M-3100"} })
  }
).then(result => result.json().then(console.log));

// DELETE -delete existing one
fetch('/students/17', { method: 'DELETE' }).then(result => console.log(result))


// ------------------------------------------------------------------/schedule------------------------------
// GET -retrive all schedule
fetch('/schedule/').then(response => response.json().then(console.log))

// GET -retrive all schedule for giving day
fetch('/schedule?dayOfWeek=MONDAY&parity=ODD').then(response => response.json().then(console.log))

// GET -retrive all schedule for group 
fetch('/schedule/group/1').then(response => response.json().then(console.log))

// GET -retrive schedule for group for giving day
fetch('/schedule/group/1?dayOfWeek=SATURDAY&parity=EVEN').then(response => response.json().then(console.log))

// GET -retrive all schedule for teacher
fetch('/schedule/teacher/1').then(response => response.json().then(console.log))

// GET -retrive schedule for teacher for giving day
fetch('/schedule/teacher/1?dayOfWeek=MONDAY&parity=any').then(response => response.json().then(console.log))

// POST -create new one
fetch(
  '/schedule', 
  { 
    method: 'POST', 
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ 	classroom: {id: 3, name: "100/1"},
    						dayOfWeek: "MONDAY",
    						group: {id: 3, name: "N-3147"},
    						lesson: "FIRST",
    						parity: "ODD",
    						subject: {id: 3, name: "АНГЛИЙСКИЙ ЯЗЫК"},
    						teacher: {id: 3, firstName: "Семен", middleName: "Алексеевич", lastName: "Петухов"} })
  }
).then(result => result.json().then(console.log))

// PUT -update existing one
fetch(
  '/schedule/175', 
  { 
    method: 'PUT', 
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ 	classroom: {id: 3, name: "100/1"},
    						dayOfWeek: "MONDAY",
    						group: {id: 3, name: "N-3147"},
    						lesson: "SECOND",
    						parity: "EVEN",
    						subject: {id: 3, name: "АНГЛИЙСКИЙ ЯЗЫК"},
    						teacher: {id: 3, firstName: "Семен", middleName: "Алексеевич", lastName: "Петухов"} })
  }
).then(result => result.json().then(console.log))

// DELETE -delete existing one
fetch('/schedule/17', { method: 'DELETE' }).then(result => console.log(result))
