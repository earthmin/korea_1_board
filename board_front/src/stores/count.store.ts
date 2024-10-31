// count.store.ts
// : 카운트값 전역 상태 관리 

import { create } from "zustand";

// *  interface: 스토어(전역 저장소)의 interface 정의
interface CountStoreType {
  // 상태 필드 정의 
  count: number;

  // 상태 업데이트 함수
  increament: () => void;
  decreament: () => void;
}

// 저장소 생성 함수: create<저장소 intesface>();
const useCountStore = create<CountStoreType>((set) => ({
  // 상태 필드 초기화 
  count: 0,
  increament: () => set((state) => ({
    count: state.count + 1
  })),
  decreament: () => set((state) => ({
    count: state.count - 1
  }))

}));

export default useCountStore;
