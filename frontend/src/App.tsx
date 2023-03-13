import { Routes, Route } from "react-router-dom"
import MainNavbar from './components/navbar'
import MainFooter from './components/footer'
import CreateSession from './components/create-session'
import Session from './components/session'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap'

function App() {

  return (
    <div className="d-flex flex-column min-vh-100">
		<MainNavbar />
		<Routes>
			<Route path="/" element={<CreateSession />} />
			<Route path="/:id" element={<Session />} />
		</Routes>
		<MainFooter />
	</div>
  )
}

export default App
