# npm 사용

## npm 설정 파일 만들기
- npm 설정 파일인 "package.json" 파일을 생성한다.
```
> npm init 
```

## npm으로 의존 라이브러리 가져오기
- npm을 이용하여 외부의 의존 라이브러리를 자동으로 다운로드 받을 수 있다. 
```
> npm install 라이브러리명@버전명 --save 
> npm install jquery@1.12.4 --save

라이브러리 명을 적지 않으면 package.json 파일에 등록된 모든 라이브러리를 자동으로 받는다.
> npm install
```
- 옵션
  - "--save" : 다운로드 하는 라이브러리 정보를 설정 파일(package.json)에 추가한다.
- 다운로드 받은 파일의 위치
  - "npm install"을 실행한 폴더에 "node_modules"라는 폴더가 생성된다. 
  - "node_modules"라는 폴더에 라이브러리를 다운로드 한다.
  - "node_modules"의 폴더명을 바꾸지 말고 그대로 사용하라!