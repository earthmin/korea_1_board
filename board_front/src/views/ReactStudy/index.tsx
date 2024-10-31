import React from 'react'
import UseState from '../../react-study/A_useState';
import UseEffect from '../../react-study/B_useEffect';
import StateEffect from '../../react-study/C_StateEffect';
import ReactCookie from '../../react-study/D_react_cookie';
import Zustand from '../../react-study/E_zustand';
import ZustandReader from '../../react-study/E_zustand_render'

export default function ReactStudy() {
  return (
    <>
      <h2>UseState: 상태관리</h2>
      <UseState />

      <h2>UseEffect: 부수효과</h2>
      <UseEffect />

      <h2>State & Effect: Menu 검색 구현</h2>
      <StateEffect />

      <h2>react-cookie: 쿠키 설정 상태 관리</h2>
      <ReactCookie />

      <h2>zustnad: 전역 상태 관리</h2>
      <Zustand />
      <ZustandReader />
    </>
  )
}